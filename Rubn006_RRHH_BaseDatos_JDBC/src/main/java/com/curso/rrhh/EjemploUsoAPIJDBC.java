package com.curso.rrhh;

import java.sql.*;

public class EjemploUsoAPIJDBC {
	public static void main(String[] args) {
		
			//1. Cargar Driver JDBC Oracle 18c		
			try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("cargó ok");
			} catch (ClassNotFoundException e) {
				System.out.println("No cargó driver");
				e.printStackTrace();
				return;
			}
			//2. Crear una conexión a la BD
			
			String url = "jdbc:oracle:thin:@localhost:49161:xe";
			String usr =  "system";
			String clave = "oracle";				
			
			try (Connection con = DriverManager.getConnection(url, usr, clave)){				
				System.out.println("conectó ok");
				
				//3. consulta la lista de paises				 
//			    Statement st = con.createStatement();
//			    
//			    //3.1. lanzar consulta a base de datos
				ResultSet rs;
//			    rs = st.executeQuery ("SELECT * FROM HR.COUNTRIES");
			    
			    //3.1. Recorrer el resultado de la consulta
//			    while(rs.next()) {
//			    	System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString(2) + " "+ rs.getString(3));
//			    }
			    
			    // st.executeQuery (...) -> ResultSet
				// st.executeUpdate (...)  -> int numero de reg afectados

			    //4. INSETAR UN PAIS
//			    String sentenciaInsert = "INSERT INTO HR.COUNTRIES VALUES ('XX','PAISXX',4)";
//			    int regAfectado = st.executeUpdate(sentenciaInsert);
//				//5. CREAR UNA TABLA
//				PreparedStatement stmt = null;
//				try {
//			    	  stmt = con.prepareStatement("CREATE TABLE HR.COFFEES (COF_NAME VARCHAR(32), SUP_ID INTEGER, PRICE FLOAT, SALES INTEGER, TOTAL INTEGER)");  
//			    	  stmt.execute(); System.out.println("Create table ejecutado");   
//			    	  stmt.close();	  		    	  
//			    	} catch (SQLException sqle) { 
//			    	  System.out.println("Error en la ejecución: " 
//			    	    + sqle.getErrorCode() + " " + sqle.getMessage());    
//			    	}
//				//6. BORRAR UNA TABLA
//			    PreparedStatement stmt = null;
//			   	try {	stmt = con.prepareStatement("DROP TABLE COFFEES2 ");  stmt.execute(); 
//			    	  	System.out.println("Tabla borrada"); stmt.close();         	  
//			    	} catch (SQLException sqle) { 
//			    	  System.out.println("Error en la ejecución: " + sqle.getErrorCode() + " " + sqle.getMessage());    
//			    	}			    
//			   	//INSERTAR DATOS EN COFFEES
			    Statement stmt = con.createStatement();
			    stmt.executeUpdate("INSERT INTO HR.COFFEES VALUES ('Colombian', 101, 7.99, 0, 0)");
			    stmt.executeUpdate("INSERT INTO HR.COFFEES VALUES ('French_Roast', 49, 8.99, 0, 0)");
			    stmt.executeUpdate("INSERT INTO HR.COFFEES VALUES ('Expresso', 150, 9.99, 0, 0)");
			    
			    rs = stmt.executeQuery("SELECT COF_NAME, PRICE FROM HR.COFFEES");
			    while(rs.next()) {
			    	System.out.println(rs.getString("COF_NAME"));
			    }
			} catch (SQLException e) {

				System.out.println("Error BD " + e.getMessage());
				e.printStackTrace();
			}
	}
}
