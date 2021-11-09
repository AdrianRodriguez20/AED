package es.iespuertodelacruz.adrian.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import es.iespuertodelacruz.adrian.instituto.modelo.Asignatura;

public class AsignaturaDAO implements Crud<Asignatura, String> {

	GestorConexionDDBB gc;

	public AsignaturaDAO(GestorConexionDDBB gc) {
		this.gc = gc;
	}

	public Asignatura save(Asignatura dao) {

		String sql = "INSERT INTO asignaturas (nombre, curso ) VALUES(?,?)";
		Asignatura asignatura= null;
		try (Connection conn = gc.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, dao.getNombre());
			pstmt.setString(2, dao.getCurso());
			int filasAfectadas = pstmt.executeUpdate();
			if( filasAfectadas > 0) {
				asignatura = new Asignatura(dao.getNombre(),dao.getCurso());
				try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		                asignatura.setIdAsignatura(generatedKeys.getInt(1));
		            }
		        }
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
		}

		return asignatura;
	}

	@Override
	public Asignatura findById(String id) {
		return null;
	}

	public Asignatura findById(int id) {

		ArrayList<Asignatura> asignaturas = null;
		String sql = "SELECT idasignatura ,nombre, curso FROM asignaturas  WHERE  idasignatura = ?";

		try (Connection conn = gc.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);

			ResultSet resultSet = pstmt.executeQuery();
			asignaturas = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		if (asignaturas != null && asignaturas.size()>0) {
			return asignaturas.get(0);
		} else {
			return null;
		}
	}

	public boolean update(Asignatura dao) {

		String sql = "UPDATE asignaturas SET nombre = ?, curso = ?  WHERE idasignatura= ?";
		Boolean exito=false;
		
		try (Connection conn = gc.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dao.getNombre());
			pstmt.setString(2, dao.getCurso());
			pstmt.setLong(3, dao.getIdAsignatura());
			int filasAfectadas = pstmt.executeUpdate();
			if( filasAfectadas > 0) {
			exito=true;
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido un error actualizando en la BBDD:" + e.getMessage());
		}

		return exito;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}

	public boolean delete(int id) {
		Boolean exito=false;
		 String sql = "DELETE FROM asignaturas  WHERE  idasignatura = ?";

			try (Connection conn = gc.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, id);

				int filasAfectadas = pstmt.executeUpdate();
				if( filasAfectadas > 0) {
				exito=true;
				}
	        } catch (SQLException e) {
	            System.out.println("Se ha producido un error eliminando en la BBDD:" + e.getMessage());
	        }

		return exito;
	}

	public ArrayList<Asignatura> findAll() {

		ArrayList<Asignatura> asignaturas = null;
		String sql = "SELECT idasignatura ,nombre, curso FROM asignaturas";

		try (Connection conn = gc.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			ResultSet resultSet = pstmt.executeQuery();
			asignaturas = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}
		return asignaturas;
	}

	public ArrayList<Asignatura> findAsignaturasAlumnoByIdAndYear(String dni , int year) {

		ArrayList<Asignatura> asignaturas = null;
		String sql = "SELECT idasignatura , nombre , curso FROM asignaturas WHERE idasignatura in"
				+ "(SELECT idasignatura FROM asignatura_matricula WHERE idmatricula = "
				+ "(SELECT idmatricula FROM matriculas WHERE dni = ? and year = ? ))";


		try (Connection conn = gc.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dni);
			pstmt.setInt(2, year);
			ResultSet resultSet = pstmt.executeQuery();
			asignaturas = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}
		return asignaturas;
	}

	public Asignatura findByNombre(String nombre) {

		ArrayList<Asignatura> asignaturas = null;
		String sql = "SELECT idasignatura ,nombre, curso FROM asignaturas  WHERE  nombre = ?";

		try (Connection conn = gc.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nombre);

			ResultSet resultSet = pstmt.executeQuery();
			asignaturas = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		if (asignaturas != null && asignaturas.size()>0) {
			return asignaturas.get(0);
		} else {
			return null;
		}
	}

	/*
	 * Funcion que transforma un resultSet en una lista de partidas
	 * 
	 * @param resultSet
	 * 
	 * @return
	 */
	public static ArrayList<Asignatura> resultSetToList(ResultSet resultSet) {
		ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();

		try {
			while (resultSet.next()) {
				asignaturas.add(new Asignatura(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (SQLException sqlException) {
			System.out.println(
					"Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());

		}

		return asignaturas;
	}

}
