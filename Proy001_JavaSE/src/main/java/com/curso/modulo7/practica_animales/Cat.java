package com.curso.modulo7.practica_animales;

public class Cat extends Animal implements Pet{
	private String name;
	
	public Cat() {
		super(4);	
		this.name = "no tengo nombre";
	}
	
	public Cat(String n) {
		this();	
		this.name = n;
	}

	@Override
	public void eat() {
		System.out.println("soy gato y como comida de gato");
		
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
		System.out.println("soy gato, me llamo "+ this.name + " y juego como gato");
		
	}

}
