package com.curso.flota.pruebas;

import com.curso.flota.dominio.Camion;
import com.curso.flota.dominio.Vehiculo;

public class Pruebas {
	
	public static void main(String[] args) {
		
		Vehiculo camion = new Camion("2345JJJ", 500.10);
//		camion.cargaMaxima = 555.25; //atributo cargaMaxima es public
		
		try {
			
			camion.setCargaMaxima(600);
			
			System.out.printf("EL cambion con matricula %s "
					+ "tiene una carga actual de %f kg %n", 
					camion.getMatricula(), 
					camion.getCargaActual()); //salida de forma formateada con elementos con printf
			
			System.out.println("cargo una caja de 560 kg %n");
			camion.cargarCaja(560);
			
			System.out.printf("EL cambion con matricula %s "
					+ "tiene una carga actual de %f kg %n", 
					camion.getMatricula(), 
					camion.getCargaActual());
			
			System.out.println("cargo una caja de 560 kg %n");
			camion.cargarCaja(100);
			
			
		
		}catch (Exception e) {
			System.out.println("No pudo cargar, " + e.getMessage());
		}
	}
	
}
