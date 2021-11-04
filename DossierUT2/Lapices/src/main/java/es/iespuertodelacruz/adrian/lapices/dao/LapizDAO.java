package es.iespuertodelacruz.adrian.lapices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import es.iespuertodelacruz.adrian.lapices.modelo.Lapiz;

public class LapizDAO implements Crud<Lapiz, String> {

	GestorConexionDDBB gc;
	
	

	public LapizDAO(GestorConexionDDBB gc) {
		super();
		this.gc = gc;
	}

	public Lapiz save(Lapiz dao) {
		
		String sql = "INSERT INTO lapices (marca, numero ) VALUES(?,?)";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1,dao.getMarca());
			pstmt.setInt(2, dao.getNumero());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
		}

		return null;
	}

	public Lapiz findById(String id) {
		
		ArrayList<Lapiz> lapices = null;
		String sql = "SELECT idlapiz ,marca, numero FROM lapices  WHERE  idlapiz = ?";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet resultSet = pstmt.executeQuery();
			lapices = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		if (lapices != null) {
			return lapices.get(0);
		} else {
			return null;
		}
	}

	public ArrayList<Lapiz> findByMarca(String marca) {
		
		ArrayList<Lapiz> lapices = null;
		String sql = "SELECT idlapiz ,marca, numero FROM lapices  WHERE  marca = ?";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, marca);

			ResultSet resultSet = pstmt.executeQuery();
			lapices = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}

		return lapices;
	}
	public boolean update(Lapiz dao) {
	
		String sql = "UPDATE lapices SET marca = ?, numero = ?  WHERE idlapiz= ?";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dao.getMarca());
			pstmt.setInt(2, dao.getNumero());
			pstmt.setInt(3, dao.getIdlapiz());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido un error actualizando en la BBDD:" + e.getMessage());
		}

		return false;
	}

	public boolean delete(String id) {
		
		 String sql = "DELETE FROM lapices  WHERE  idlapiz = ?";

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

	public ArrayList<Lapiz> findAll() {
		ArrayList<Lapiz> lapices = null;
		String sql = "SELECT idlapiz ,marca, numero FROM lapices";

		try {
			Connection conn = gc.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			lapices = resultSetToList(resultSet);
		} catch (SQLException e) {
			System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
		}
		return lapices;
	}
	
	static ArrayList<Lapiz> resultSetToList(ResultSet resultSet) {
		ArrayList<Lapiz> lapices = new ArrayList<Lapiz>();

		try {
			while (resultSet.next()) {
				lapices.add(new Lapiz(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}
		} catch (SQLException sqlException) {
			System.out.println(
					"Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());

		}

		return lapices;
	}
}
