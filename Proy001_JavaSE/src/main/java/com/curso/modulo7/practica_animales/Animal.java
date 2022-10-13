package com.curso.modulo7.practica_animales;

public abstract class Animal {
	public int legs;
	public Animal(int legs) {
		this.legs = legs;
	}
	public void walk() {
		System.out.println("Estoy andando con "+this.legs+" patas");
	}
	public abstract void eat();
	
}
