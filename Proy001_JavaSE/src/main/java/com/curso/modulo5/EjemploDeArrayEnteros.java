package com.curso.modulo5;

public class EjemploDeArrayEnteros {

	public static void main(String[] args) {

		int[] numeros; // declaro un array de tipos int

		numeros = new int[4]; // creo un array de enteros inicializados a 0

		numeros[0] = 7;
		numeros[3] = 2;

		for (int n : numeros) {
			System.out.println(n);
		}

		// declarar e inicializar
		int[] cantidades = { 1, 34, 56, 0, 23 };
	}

}
