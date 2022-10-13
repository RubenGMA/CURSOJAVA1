package com.curso.flota.pruebas;

import com.curso.flota.dominio.Barcaza;
import com.curso.flota.dominio.Caja;
import com.curso.flota.dominio.Camion;
import com.curso.flota.dominio.Moto;
import com.curso.flota.dominio.Vehiculo;
import com.curso.flota.informes.InformeConbustibleNecesario;

public class PruebasAbstraccion {
	public static void main(String[] args) {
		Vehiculo[] flota = new Vehiculo[4];
		flota[0] = new Barcaza("A1111", 1000);
		flota[1] = new Camion("A1124", 1000,3);
		flota[2] = new Barcaza("A3541", 1000);
		flota[3] = new Moto("A1444", 1000);
		
		for(Vehiculo v: flota) {
			System.out.println(v.getMatricula() + " le cargo una caja");
			v.cargarCaja(new Caja());
		}
		
		InformeConbustibleNecesario inf = new InformeConbustibleNecesario(flota);
		inf.generateText(System.out);
		
		Moto m = new Moto("2554", 98);
		
	}
}
