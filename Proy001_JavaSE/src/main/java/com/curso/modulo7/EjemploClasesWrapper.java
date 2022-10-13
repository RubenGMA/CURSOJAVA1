package com.curso.modulo7;

public class EjemploClasesWrapper {
	public static void main(String[] args) {
		int numero = 2;
		Integer numero2 = new Integer(2); //ya no se usa
		Integer numero3 = 2; //Internamente hace new Integer(2);
		
		int a = numero3;
		
		int b = numero3 + new Integer(4);
		
		//comparacion
		
		//compara la dirección de memoria con ==
		//compara el contenido con .equals
		Integer n1 = 128;
		Integer n2 = 128;
		
		System.out.println("n1 == n2 " + (n1==n2)); //es true pero da false
		
		Integer n3 = new Integer(128);
		Integer n4 = 128;
		System.out.println("n1 == n3 " + (n1==n3)); //es true pero da false
		System.out.println("n3 = n4 con equals " + (n3.equals(n4))); //es true y da true
		
	}
}
