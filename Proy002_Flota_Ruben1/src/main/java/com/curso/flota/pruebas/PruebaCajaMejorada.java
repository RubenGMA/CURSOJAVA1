package com.curso.flota.pruebas;

import com.curso.flota.dominio.Caja;
import com.curso.flota.dominio.CargaException;
import com.curso.flota.dominio.VehiculoMejorado;

public class PruebaCajaMejorada {
	public static void main(String[] args) {
		VehiculoMejorado v = new VehiculoMejorado("aa", 300);
		
		//creo una caja muy grande y no cabe
		Caja c = new Caja();
		c.setPeso(350);
		
		//añadir la caja al vehiculo
		try {
			v.cargarCaja(c);
		} catch (CargaException e) {
			System.out.println("Error " + e.getMessage());
			System.out.println("Exceso de carga es " + e.getExcesoCarga());
		} //no me obliga a capturar la excepcion por que es silenciosa
	}
}
