package com.curso.modulo6;

public class EjemploArgVariable {
	
	private static int suma(int n, int nn, int nnn) {//1
		return n+nn+nnn;
	}
	private static int suma(int n, int nn) {//2
		return n+nn;
	}
	private static int suma(int... numeros) {//3
		int r=0;
		for(int i: numeros) {
			r += i;
		}
		return r;
	}
	public static void main(String[] args) {
		suma(2,3,4);
		suma(2,5);
		int[] numerosSumar = {4,5,6,9};
		suma(numerosSumar);
	}
}
