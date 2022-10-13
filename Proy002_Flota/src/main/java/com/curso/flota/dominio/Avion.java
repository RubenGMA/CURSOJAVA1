package com.curso.flota.dominio;

import java.util.Date;

public class Avion 
			extends Vehiculo 
			implements Volable, Reservable{

	protected Avion(String matricula, double cargaMaxima) {
		super(matricula, cargaMaxima);
		
	}

	@Override
	public double consumofuel() {
		
		return 987.70;
	}

	@Override
	public void despegar() {
		System.out.println("Despego como avión");
		
	}

	@Override
	public void aterrizar() {
		System.out.println("aterrizo como avión");
		
	}

	@Override
	public void volar() {
		System.out.println("vuelo como un  avion de dos motores");
		
	}

	@Override
	public void reservar(Date fechaReserva) {
		System.out.println("Reservo un vuelo en la fecha" + fechaReserva);
	}
	
}
