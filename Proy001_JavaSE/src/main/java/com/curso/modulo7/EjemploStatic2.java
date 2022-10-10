package com.curso.modulo7;

import java.sql.Connection;

// ConexionesBDUtil
public class EjemploStatic2 {
	public static final String USER_DB = "alfresco";
	public static final String URL_DB = "asdfghjkl";
	
	//Si no queremos que se instancien objetos de la clase
	//se declara el constructor private.
	private EjemploStatic2() {
		
	}
	
	public static Connection getConection() {
		return null;
	}
	
	public static void main(String[] args) {
		String url = EjemploStatic2.URL_DB;
		Connection c = EjemploStatic2.getConection();
		EjemploStatic2 e = new EjemploStatic2();
	}
}
