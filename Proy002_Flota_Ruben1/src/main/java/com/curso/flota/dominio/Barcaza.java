package com.curso.flota.dominio;

public class Barcaza extends Vehiculo {

	public Barcaza(String matricula, double cargaMaxima) {
		super(matricula, cargaMaxima);
	}

	@Override
	public double consumofuel() {
		return 300.4;
	}

}
