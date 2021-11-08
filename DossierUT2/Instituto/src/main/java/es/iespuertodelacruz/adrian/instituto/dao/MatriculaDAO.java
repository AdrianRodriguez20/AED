package es.iespuertodelacruz.adrian.instituto.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;
import es.iespuertodelacruz.adrian.instituto.modelo.Matricula;

public class MatriculaDAO implements Crud<Matricula, String> {

	GestorConexionDDBB gc;

	public MatriculaDAO(GestorConexionDDBB gc) {
		this.gc = gc;
	}

	public Matricula save(Matricula dao) {

		AlumnoDAO alumnoDao = new AlumnoDAO(gc);
		Alumno alumno = alumnoDao.findById(dao.getAlumno().getDni());
		Matricula matricula = null;
		if (alumno != null) {

			String sqlMatri = "INSERT INTO matriculas (dni, year ) VALUES(?,?)";
			String sqlAsigMatri = "INSERT INTO asignatura_matricula (idmatricula , idasignatura) VALUES (?,?)";
			try (Connection conn = gc.getConnection();
				 PreparedStatement pstmtMatri = conn.prepareStatement(sqlMatri, PreparedStatement.RETURN_GENERATED_KEYS);
				 PreparedStatement pstmtAsigMatri = conn.prepareStatement(sqlAsigMatri, PreparedStatement.RETURN_GENERATED_KEYS)
			) {
				pstmtMatri.setString(1, dao.getAlumno().getDni());
				pstmtMatri.setInt(2, dao.getYear());
				int filasAfectadasMatri = pstmtMatri.executeUpdate();

				int filasAfectadasAsigMatri=0;
				if (filasAfectadasMatri > 0  ) {
					matricula = new Matricula(dao.getAlumno(), dao.getYear(), null);
					try (ResultSet generatedKeys = pstmtMatri.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							matricula.setIdmatricula(generatedKeys.getInt(1));
						}
					}
				}
				for (int i = 0; i < dao.getAsignaturas().size(); i++) {
					pstmtAsigMatri.setInt(1, matricula.getIdmatricula());
				    pstmtAsigMatri.setInt(2, dao.getAsignaturas().get(i).getIdAsignatura());
					pstmtAsigMatri.addBatch();
					pstmtAsigMatri.executeBatch();
				}

					matricula.setAsignaturas(dao.getAsignaturas());


			} catch (SQLException e) {
				System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
			}
		}

		return matricula;
	}

	@Override
	public Matricula findById(String id) {
		return null;
	}

	public Matricula findById(String dni, int year) {

		String sql = " SELECT idmatricula , year FROM matriculas WHERE dni = ? and year = ?";

		AlumnoDAO alumnoDAO = new AlumnoDAO(gc);
		AsignaturaDAO asignaturaDAO = new AsignaturaDAO(gc);
		Matricula matricula = null;

		try (Connection conn = gc.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dni);
			pstmt.setInt(2, year);

			ResultSet resultSet = pstmt.executeQuery();

			if (resultSet.next()) {
				matricula = new Matricula();
				matricula.setIdmatricula(resultSet.getInt(1));
				matricula.setYear(resultSet.getInt(2));

			}
			matricula.setAlumno(alumnoDAO.findById(dni));
			matricula.setAsignaturas(asignaturaDAO.findAsignaturasAlumnoByIdAndYear(dni, year));

		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		return matricula;
	}

	public boolean update(Matricula dao) {

		String queryDelete = "DELETE FROM asignatura_matricula WHERE idmatricula = ? ";
		String queryUpdate = "UPDATE matriculas SET dni= ?, year= ? WHERE idmatricula = ? ";
		String queryInsert = "INSERT INTO asignatura_matricula(idasignatura,idmatricula) VALUES(?,?) ";
		boolean ok = false;
		try (Connection conn = gc.getConnection();
				PreparedStatement psDelete = conn.prepareStatement(queryDelete);
				PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
				PreparedStatement psInsert = conn.prepareStatement(queryInsert);) {
			conn.setAutoCommit(false);

			psDelete.setInt(1, dao.getIdmatricula());
			int respuesta = psDelete.executeUpdate();
			psUpdate.setString(1, dao.getAlumno().getDni());
			psUpdate.setInt(2, dao.getYear());
			psUpdate.setInt(3, dao.getIdmatricula());
			respuesta = psUpdate.executeUpdate();
			ok = respuesta > 0; // entendemos que debe haber alguna fila borrada si ok
			if (ok) {

				// â€¦ .. .. â†�AquÃ­ el resto del cÃ³digo
				// si todo sale bien, al final hay un commit
				conn.commit();
				conn.setAutoCommit(true);
			} else {
				conn.rollback();
				conn.setAutoCommit(true);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return ok;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Matricula> findAll() {
		return null;
	}

	public ArrayList<Matricula> findByDni(String id) {

		String sql = "SELECT year FROM matriculas WHERE dni = ?";


		ArrayList <Matricula> matriculas =null;
		try (Connection conn = gc.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);

			ResultSet resultSet = pstmt.executeQuery();
			ArrayList<Integer> years = new ArrayList<>();

			matriculas = new ArrayList<>();
			while (resultSet.next()) {
				years.add( Integer.parseInt(resultSet.getString(1)));
			}
			for (int year : years) {
			matriculas.add(findById(id, year));
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		return matriculas;
	}

	public ArrayList<Matricula> findByAnio(int anio) {

		String sql = "SELECT dni FROM matriculas WHERE year = ?";

		ArrayList <Matricula> matriculas =null;
		try (Connection conn = gc.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, anio);

			ResultSet resultSet = pstmt.executeQuery();
			ArrayList<String> dnis = new ArrayList<>();

			matriculas = new ArrayList<>();
			while (resultSet.next()) {
				dnis.add( resultSet.getString(1));
			}
			for (String dni : dnis) {
				matriculas.add(findById(dni, anio));
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		return matriculas;
	}
}
