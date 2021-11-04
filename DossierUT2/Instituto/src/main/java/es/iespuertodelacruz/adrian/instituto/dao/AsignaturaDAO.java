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

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, dao.getNombre());
			pstmt.setString(2, dao.getCurso());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
		}

		return null;
	}

	public Asignatura findById(String id) {

		ArrayList<Asignatura> asignaturas = null;
		String sql = "SELECT idasignatura ,nombre, curso FROM asignaturas  WHERE  idasignatura = ?";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet resultSet = pstmt.executeQuery();
			asignaturas = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		if (asignaturas != null) {
			return asignaturas.get(0);
		} else {
			return null;
		}
	}

	public boolean update(Asignatura dao) {

		String sql = "UPDATE asignaturas SET nombre = ?, curso = ?  WHERE idasignatura= ?";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dao.getNombre());
			pstmt.setString(2, dao.getCurso());
			pstmt.setLong(3, dao.getIdAsignatura());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido un error actualizando en la BBDD:" + e.getMessage());
		}

		return false;
	}

	public boolean delete(String id) {

		 String sql = "DELETE FROM asignaturas  WHERE  idasignatura = ?";

		  try {
			  	Connection conn =  gc.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);

	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Se ha producido un error eliminando en la BBDD:" + e.getMessage());
	        }

		return false;
	}

	public ArrayList<Asignatura> findAll() {

		ArrayList<Asignatura> asignaturas = null;
		String sql = "SELECT idasignatura ,nombre, curso FROM asignaturas";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			asignaturas = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}
		return asignaturas;
	}

	/*
	 * Funcion que transforma un resultSet en una lista de partidas
	 * 
	 * @param resultSet
	 * 
	 * @return
	 */
	static ArrayList<Asignatura> resultSetToList(ResultSet resultSet) {
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
