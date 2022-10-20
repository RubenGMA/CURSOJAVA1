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
			    
			    //3.1. lanzar consulta a base de datos
			    ResultSet rs = st.executeQuery ("SELECT * FROM HR.COUNTRIES");
			    
			    //3.1. Recorrer el resultado de la consulta
			    while(rs.next()) {
			    	System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString(2) + " "+ rs.getString(3));
			    }
			    
			    // st.executeQuery (...) -> ResultSet
				// st.executeUpdate (...)  -> int numero de reg afectados

			    //4. INSETAR UN PAIS
			    String sentenciaInsert = "INSERT INTO HR.COUNTRIES VALUES ('XX','PAISXX',4)";
			    int regAfectado = st.executeUpdate(sentenciaInsert);
			    
			    System.out.printf("inserto %d registros", regAfectado);
				
			} catch (SQLException e) {

				System.out.println("Error BD " + e.getMessage());
				e.printStackTrace();
			}
	}
}
