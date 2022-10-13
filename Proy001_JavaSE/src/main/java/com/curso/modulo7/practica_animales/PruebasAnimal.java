package com.curso.modulo7.practica_animales;

public class PruebasAnimal {
	public static void main(String[] args) {
		Fish f = new Fish();
		Cat c = new Cat("Fluffy");
		Animal a = new Fish();
		Animal e = new Spider();
		Pet p = new Cat();
		
		// Demostrar distintas implementaciones de una interfaz
		f.play();
		c.play();
		// Demostrar llamada a métodos virtuales
		e.eat();
		e.walk();
		// Demostrar llamada a métodos super
		a.walk();
	}
}
