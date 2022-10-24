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
			    Statement st = con.createStatement();
//			    
//			    //3.1. lanzar consulta a base de datos
				ResultSet rs;
			    rs = st.executeQuery ("SELECT * FROM HR.COUNTRIES");
			    
			    
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
//			    Statement stmt = con.createStatement();
//			    stmt.executeUpdate("INSERT INTO HR.COFFEES VALUES ('Colombian', 101, 7.99, 0, 0)");
//			    stmt.executeUpdate("INSERT INTO HR.COFFEES VALUES ('French_Roast', 49, 8.99, 0, 0)");
//			    stmt.executeUpdate("INSERT INTO HR.COFFEES VALUES ('Expresso', 150, 9.99, 0, 0)");
//			    
//			    rs = stmt.executeQuery("SELECT COF_NAME, PRICE FROM HR.COFFEES");
//			    while(rs.next()) {
//			    	System.out.println(rs.getString("COF_NAME"));
//			    }
				
//			    String modifPais = "UPDATE HR.COUNTRIES "
//						+ " SET COUNTRY_NAME = ? "
//						+ " WHERE COUNTRY_ID = ? "; 
//				PreparedStatement ps = con.prepareStatement(modifPais);
//				
//				String pais = "ArgentinaModif2";
//				String cod = "AR";//"AR' OR '1'='1" ; 
//				
//				//pasar parametros  
//				ps.setString(1, pais);
//				ps.setString(2, cod);
//				
			    
				//Crear procedimiento almacenado
				String crearProcAlmacenado = 
						"create or replace PROCEDURE   HR.Ver_NombrePais " 
						+"(PARAM_COD_PAIS IN varchar, PARAM_NOMBRE_PAIS OUT VARCHAR ) AS "
						+"BEGIN " 
						+      "SELECT COUNTRY_NAME  INTO PARAM_NOMBRE_PAIS "
						+      "FROM HR.COUNTRIES "    
						+     "WHERE COUNTRY_ID = PARAM_COD_PAIS; "
						+"END; ";

//				con.createStatement().execute(crearProcAlmacenado);
				
				//llamar desde java a un proc almacenado,
				String codigo = "AR";
				CallableStatement call = con.prepareCall("{call HR.Ver_NombrePais(?,?)}");
				//preprar parametros de la call
				call.setString(1, codigo);
				//el segundo es de salida
				call.registerOutParameter(2, java.sql.Types.VARCHAR);
				//ejecutar
				call.executeQuery();
				//leer valor
				String nombrePaisRecuperado = call.getString(2);
				
//				System.out.printf("el nombre del pais %s es %s. ", codigo, nombrePaisRecuperado);			
//				modificiarPaises(con, "AR","US");
				
				String crearTablaProducto = "CREATE TABLE HR.PRODUCTOS "
						+ "   (	ID_PRODUCTO NUMBER NOT NULL ENABLE PRIMARY KEY,"
						+ "	DESCRIPCION VARCHAR2(50 BYTE) NOT NULL ENABLE,"
						+ "	PRECIO NUMBER DEFAULT 0 NOT NULL ENABLE, "
						+ "	STOCK NUMBER DEFAULT 0 NOT NULL ENABLE) ";
//				con.createStatement().execute(crearTablaProducto);
				
				String insertProducto1 = "INSERT INTO HR.PRODUCTOS " +
						"(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) " +
						" VALUES (1, 'Television', 1522.8, 5)";
				String insertProducto2 = "INSERT INTO HR.PRODUCTOS " +
						"(ID_PRODUCTO, DESCRIPCION, PRECIO, STOCK) " +
						" VALUES (2, 'Zapatos', 153.8, 20)";
				con.createStatement().execute(insertProducto1);
				con.createStatement().execute(insertProducto2);
						
				
			} catch (SQLException e) {

				System.out.println("Error BD " + e.getMessage());
				e.printStackTrace();
			}
	}
	
	public static void modificiarPaises(Connection conexion,String... codigos) {
		//Crear un conexto transaccional
		//en el que se ejecutan como un todo varias sentencias sql
		//si falla una falan todas
		
		try {
			conexion.setAutoCommit(false);
			
			String modifPais = "UPDATE HR.COUNTRIES "
					+ " SET COUNTRY_NAME = COUNTRY_NAME" + " || ' ' "
					+ " WHERE COUNTRY_ID = ? "; 
			PreparedStatement ps = conexion.prepareStatement(modifPais);
			
			
			for(String codigo: codigos) {
				ps.setString(1, codigo);
				ps.executeUpdate();
			}
			
			
			conexion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
		}
	}
	
}
