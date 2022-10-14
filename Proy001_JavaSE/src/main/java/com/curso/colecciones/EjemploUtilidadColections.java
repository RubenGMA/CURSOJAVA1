package com.curso.colecciones;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class EjemploUtilidadColections {
	public static void main(String[] args) {
		Set<Integer> valores = new HashSet();
		valores.add(25);
		valores.add(1);
		valores.add(10);
		valores.add(35);
		valores.add(8);
		
		for(Integer i : valores) {
			System.out.println(i);
		}
		
	}
}
