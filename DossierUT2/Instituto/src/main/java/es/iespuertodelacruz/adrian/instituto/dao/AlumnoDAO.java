package es.iespuertodelacruz.adrian.instituto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iespuertodelacruz.adrian.instituto.modelo.Alumno;

public class AlumnoDAO implements Crud<Alumno, String> {
	
	GestorConexionDDBB gc;

	public AlumnoDAO(GestorConexionDDBB gc) {
		this.gc = gc;
	}

	public Alumno save(Alumno dao) {

	       String sql = "INSERT INTO alumnos (dni,nombre, apellidos, fechanacimiento) VALUES(?,?,?,?)";

	        try {
	            Connection conn =  gc.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, dao.getDni());
	            pstmt.setString(2, dao.getNombre());
	            pstmt.setString(3, dao.getApellidos());
	            pstmt.setLong(4, dao.getFechanacimiento());
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Se ha producido un error almacenando en la BBDD:" + e.getMessage());
	        } 
	        
	        return null;
	}

	public Alumno findById(String id) {
		
		ArrayList<Alumno> alumnos = null;
		 String sql = "SELECT dni,nombre, apellidos, fechanacimiento FROM alumnos WHERE  dni = ?";

		  try {
			  	Connection conn =  gc.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);

	            ResultSet resultSet = pstmt.executeQuery();
	           // alumnos = resultSetToList(resultSet);
	        } catch (SQLException e) {
	            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
	        }
		return null; 
	}

	public boolean update(Alumno dao) {
		
		String sql = "UPDATE alumnos SET nombre = ?, apellidos = ? , fechanacimiento = ? WHERE dni= ?";
		
		 try {
			  	Connection conn =  gc.getConnection();
		        PreparedStatement pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, dao.getNombre());
	            pstmt.setString(2, dao.getApellidos());
	            pstmt.setLong(3, dao.getFechanacimiento());
	            pstmt.setString(4, dao.getDni());
		        pstmt.executeUpdate();
		        
		 }catch (SQLException e) {
	            System.out.println("Se ha producido un error actualizando en la BBDD:" + e.getMessage());
	     } 
		 
		return false;
	}

	public boolean delete(String id) {

		 String sql = "DELETE FROM alumnos  WHERE  dni = ?";

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

	public ArrayList<Alumno> findAll() {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		 String sql = "SELECT dni,nombre, apellidos, fechanacimiento FROM alumnos";

		  try {
			  	Connection conn =  gc.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql);
	            ResultSet resultSet = pstmt.executeQuery();
	           // alumnos = resultSetToList(resultSet);
	            
	        } catch (SQLException e) {
	            System.out.println("Se ha producido un error realizando la consulta en la BBDD:" + e.getMessage());
	        }
		return alumnos; 
	}
	
    /*
     * Funcion que transforma un resultSet en una lista de partidas
     * @param resultSet
     * @return
     */
	/*
    static ArrayList<Alumno> resultSetToList(ResultSet resultSet) {
        ArrayList<Alumno> alumnos = new ArrayList<Alumno>();

        try {
            while (resultSet.next()) {
                alumnos.add(
                		new Alumno(
                				resultSet.getString(1), 
                				resultSet.getString(2), 
                				resultSet.getString(3), 
                				new Date(resultSet.getLong(4)*1000),
                				
                				));
            }
        } catch (SQLException sqlException) {
            System.out.println("Se ha producido un error transformando los datos de la consulta:" + sqlException.getMessage());

        }

        return alumnos;
    }

	*/     

}