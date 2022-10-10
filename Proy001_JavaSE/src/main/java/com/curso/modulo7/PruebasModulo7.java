package com.curso.modulo7;

import java.sql.Connection;

public class PruebasModulo7 {
	public static void main(String[] args) {
		String url = EjemploStatic2.URL_DB;
		Connection c = EjemploStatic2.getConection();
//no se puede crear nuevas instancias de la clase:
		//EjemploStatic2 e = new EjemploStatic2();
	}
}
