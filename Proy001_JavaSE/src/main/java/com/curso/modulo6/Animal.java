package com.curso.modulo6;

public class Animal {
	private String sonido;
	
	//ejemplo de opciones que hay en un main con animales
	public static void main(String[] args) {
		Gato g = new Gato();
		
		Animal a = new Perro();
		Perro p = new Perro();
		
		PerroCaza p2 = new PerroCaza(); //Perrocaza
		a = p2; //Animal
		p = p2; //Perro
		
		if(p instanceof PerroCaza) {
			PerroCaza caza = (PerroCaza)p;
			//classCaseException si no fuera un perro de caza
			caza.olfatearPresa();
			
		}
	}
	
	public void comer() {
		System.out.println("estoy comiendo");
	}
}

class Perro extends Animal{
	private String raza;
	
	@Override
	public void comer() {
		System.out.println("Como huesos o pienso");
	}
}
class PerroCaza extends Perro{
	private int altura;
	public void olfatearPresa() {
		System.out.println("oliendo la presa");
	}
}
class Gato extends Animal{
	@Override
	public void comer() {
		System.out.println("Como ratones");
	}
}

class Vaca extends Animal{
	@Override
	public void comer() {
		System.out.println("Como hierva");
	}
}