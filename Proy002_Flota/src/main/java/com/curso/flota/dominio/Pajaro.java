package com.curso.flota.dominio;

public class Pajaro implements Volable{

	@Override
	public void despegar() {
		System.out.println("despego como un pajaro");
		
	}

	@Override
	public void aterrizar() {
		System.out.println("aterrizo como un pajaro");
		
	}

	@Override
	public void volar() {
		System.out.println("vuelo como un pajaro");
		
	}

}
