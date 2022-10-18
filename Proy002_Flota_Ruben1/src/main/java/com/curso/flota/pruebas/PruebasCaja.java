package com.curso.flota.pruebas;

import com.curso.flota.dominio.Caja;

public class PruebasCaja {
	
	public static void main(String[] args) {
		//variable de tipo primitivo
		int b = 3;
		
		//variables de memoria (punteros)
		Caja c = new Caja();
		Caja c2 = null;
		Caja c3 = new Caja();
		c2 = c3;
	}
}
