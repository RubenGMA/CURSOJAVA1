package com.curso.modulo7.practica_animales;

public class Fish extends Animal implements Pet{
	private String name;
	public Fish() {
		super(0);
		this.name = "'no me han puesto nombre'";
		
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;		
	}

	@Override
	public void play() {
		System.out.println("Soy pez, me llamo "+ this.name +" y juego como pez");
	}

	@Override
	public void eat() {
		System.out.println("Soy pez, me llamo "+ this.name +" y como comida de pez");
	}

	@Override
	public void walk() {
		System.out.println("Estoy nadando");
	}
	

}
