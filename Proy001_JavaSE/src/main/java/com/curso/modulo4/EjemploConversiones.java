package com.curso.modulo4;

public class EjemploConversiones {

	public static void main(String[] args) {	
		
		// 8 tipos primitivos
		
		//enteros
		byte  a = 1; // 8 bits -129 .. 0 .. 127
		short s = 1; // 16 bits
		int i = 1; //32 bits
		long l = 11; //64 bits
		
		//literales enteros
		int numero = 1; //literal de tipo int 32bits
		long n2 = 1; // entero 32 bits 1 cabe en un long de 64 bits
		long n3 = 1L; // literal long 64 bits
		//int n4 = 1L; 
		
		
		//casting enteros
		int x = 2;
		long y = x; //cabe por que hay casting implicito
		long z = 1L;
		int zz = (int)z; //casting explicito
						// jvm mete la tijera y corta los 33 primeros bits de los 64
		
		//decimales
		float	f = 45.5f; // 32bits
		double	d = 333.0; // 64 bits
		
		//literal double 1.0
		//literal float 1.0f (F o f) o (float)
		
		long sss = 1;
		
		//character
		char letra = 'x';	// 64 bits
		char letra2 = '\u03a6';
		
		System.out.println(letra2);
		
		int valor = letra;
		
	} 

}
