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
		Alumno alumno = alumnoDao.findById(null);
		Matricula matricula = null;
		if (alumno != null) {

			String sql = "INSERT INTO matriculas (dni, year ) VALUES(?,?)";

			try (Connection conn = gc.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
				pstmt.setString(1, dao.getAlumno().getDni());
				pstmt.setInt(2, dao.getYear());
				int filasAfectadas = pstmt.executeUpdate();
				if (filasAfectadas > 0) {
					matricula = new Matricula();
					try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							matricula.setIdmatricula(generatedKeys.getInt(1));
						}
					}
				}
			} catch (SQLException e) {
				System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
			}
		}

		return matricula;
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

	public Matricula findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
