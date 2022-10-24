package com.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class PoolConexiones {
	private String url = "jdbc:oracle:thin:@localhost:49161:xe";
	private String usr =  "system";
	private String clave = "oracle";	
	public PoolConexiones() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("cargó ok");
		} catch (ClassNotFoundException e) {
			System.out.println("No cargó driver");
			e.printStackTrace();
			throw new RuntimeException("No se pudo cargar el driver");
		}
	}
	
	public Connection getConnection() {
		Connection con;
		try {
			con = DriverManager.getConnection(url, usr, clave);
			//con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("No se pudo cargar el driver");
		}
		return con;
	}	
}
