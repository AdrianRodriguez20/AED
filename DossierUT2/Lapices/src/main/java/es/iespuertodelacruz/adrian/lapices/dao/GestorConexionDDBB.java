package es.iespuertodelacruz.adrian.lapices.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestorConexionDDBB {
	String jdbcUrl;
	String usuario;
	String clave;

	public Connection getConnection() {

		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcUrl, usuario, clave);
		} catch (SQLException ex) {
		
			System.exit(1);
		}
		return con;
	}

	public GestorConexionDDBB(String ddbb, String nombreUsuario, String password) {
		jdbcUrl = "jdbc:mysql://localhost/" + ddbb + "?serverTimezone=UTC";
		usuario = nombreUsuario;
		clave = password;
		cargarDriverMysql();
	}

	private static void cargarDriverMysql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.err.println("no carga el driver");
			System.exit(1);
		}
	}
	
	


}
