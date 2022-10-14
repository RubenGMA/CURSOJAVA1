package com.curso.colecciones;

import java.util.*;

public class EjemploColecciones {
	public static void main(String[] args) {
		//permiten tener una coleccion de Objetos
		//tamaño ilimitado
		//solo admiten objetos
		//muchos tipos de colecciones
		
		// Collection <<I>> (value)
		//		Set<<I>>
		//		List<<I>>
		
		// Map <<I>> (key - value)
		
		// Clase utilidad Collections y Arrays
		// Colecciones Genericas
		// Comparable y Comparator
		//
		
//		Colletion
//			Set					NO DUPLICADOS
//				HasSet			no ordenados
//				LinkedHasSet	ordenados por orden de insercion
//				TreeSet			orden natural (Comparable/Comparator) (alfabetico, numerico etc)
//			List
//				ArrayList
//				LinkedList
//				Queu
				
		Collection c; // Interfaz
		//Set<String> s; //Interfaz Colecciones NO DUPLICADOS
		
		Set s = new HashSet();
		s.add("Zapato");
		s.add("Avion");
		s.add(new Integer(2));
		s.add(3);
		s.add(3);
		
		s.remove("Avion");
		
		
		Set<String> nombres = new TreeSet(); //new LinkedHashSet(); // new HashSet();
		
		nombres.add("Begoña");
		nombres.add("Mario");
		nombres.add("Carlos");
		nombres.add("Perico");
		boolean añadido = nombres.add("Begoña"); //para ver que no lo ha añadido por que no permite duplicados
		
		if(!añadido)  System.out.println("no pudo añadir");
		
		for(String n: nombres) {
			System.out.println(n.toUpperCase());
		}
		
		System.out.println("................");
		Punto p1 = new Punto(0,2); Punto p2 = new Punto(1,1); Punto p3 = new Punto(1,5); 
		Punto p4 = new Punto(1,5);//lo reptimos para probar 
		Punto p5 = new Punto(1,2); Punto p6 = new Punto(0,5);
		Set<Punto> figura = new TreeSet(); // new HashSet();
		
		figura.add(p1); figura.add(p2); figura.add(p3);	figura.add(p4);	figura.add(p5);	figura.add(p6);
		
		for(Punto p : figura) {
			System.out.println(p);
		}
		
		//Comparator
		
		Set<String> apellidos = new TreeSet(new ComparadorStringOrdenInverso()); //los ordena en orden iverso
		
		apellidos.add("Olea");
		apellidos.add("Alonso");
		apellidos.add("Rosales");
		apellidos.add("Etxeondo");
		
		for (String n : apellidos ) {
			System.out.println(n.toUpperCase());
			
		}
		System.out.println("");
		//Ejemplo Cleccion de tipo List
		
		List<String> paises = new ArrayList<String>();
		
		paises.add("China");
		paises.add("Egipto");
		paises.add("Italia");
		paises.add("Perú");
		paises.add("Perú");
		paises.add("Australia");
		paises.add(0,"España");
		
		System.out.println("pais en posición 0: " + paises.get(0));
		
		System.out.printf("Paises NO ordenados: ");
		
		for(String p: paises) {
			System.out.printf(p + " ");
		}
		System.out.println("");
		Collections.sort(paises); //Es una coleccion de Strings
									//Ordena con el comparable de la clase String
		System.out.printf("Paises ORDENADOS:    ");
		for(String p: paises) {
			System.out.printf(p + " ");
		}
		
		LinkedList<String> lista = new LinkedList<String>();
		
		lista.addFirst("Hola");
		lista.add("hola2");
		lista.addLast("asds");
		lista.getFirst();
		
		//COLAS 
		System.out.println("");
		System.out.println("COLAS:");
		PriorityQueue<Integer> cola = new PriorityQueue<Integer>();
		
		cola.add(39);
		cola.add(1);
		cola.add(10);
		cola.add(23);
		
		for(Integer i: cola) {
			System.out.println(i);
		}
		
//		Integer trato = cola.peek(); 
//		System.out.println(cola.peek()); //entrega el mas importante (el primero)
		
		System.out.println(cola.poll()); //entrega el primero y lo elimina
		

	}
}
