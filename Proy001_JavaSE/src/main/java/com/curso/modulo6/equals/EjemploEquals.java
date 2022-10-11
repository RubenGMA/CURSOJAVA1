package com.curso.modulo6.equals;

public class EjemploEquals {
	public static void main(String[] args) {
		String s = "Hola"; //new String("Hola");
		String p = new String("Hola"); //crea nuevo objeto, sin el new no lo crea.
		System.out.println("p==s " + (p==s));
		s= s.toUpperCase();
		System.out.println(s);
	}
}
