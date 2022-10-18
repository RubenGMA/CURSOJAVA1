package com.curso.flota.informes;

import java.io.PrintStream;

import com.curso.flota.dominio.Vehiculo;

public class InformeConbustibleNecesario {
	private Vehiculo[] flota;
	
	public InformeConbustibleNecesario(Vehiculo[] flota) {
		super();
		this.flota = flota;
	}
	public void generateText(PrintStream out) {
		out.println("... Informe consumo combustible");
		
		for(Vehiculo v: flota) {
			out.printf(" el vehiculo con matriula %s consume %5.2f %n", 
					v.getMatricula(),v.consumofuel());
		}
	}
}
