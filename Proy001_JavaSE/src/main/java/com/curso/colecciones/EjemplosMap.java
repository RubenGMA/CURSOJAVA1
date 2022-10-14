package com.curso.colecciones;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EjemplosMap {

	public static void main(String[] args) {

		// Map <<Interface>>

		// . solo tarbaja con objeros
		// . key - unico NO DUPLICADOS
		// . value - si duplicamos
		Map map;
		// map.put(key,value);
		// map.get(key):value;

		// key no duplicado - value
		map = new HashMap(); // no ordenado

		Map<Integer, Punto> figura = new HashMap();

		figura.put(1, new Punto(0, 0));
		figura.put(10, new Punto(4, 6));
		figura.put(10, new Punto(8, 8)); // ahora 10 apunta a (8,8)

		System.out.println(figura.get(10));

		System.out.println(figura.get(1));
		figura.remove(1);
		System.out.println(figura.get(1));

		// añado mas puntos
		figura.put(10, new Punto(4, 6));
		figura.put(2, new Punto(6, 6));
		figura.put(7, new Punto(6, 6));
		figura.put(1, new Punto(6, 6));

		Collection<Punto> valores = figura.values();
		Set<Integer> claves = figura.keySet();

		System.out.println("... recorre los valores");
		for (Punto p : valores)
			System.out.println(p);

		System.out.println("....recorre las claves  y sus valores");

		for (Integer clave : claves) {
			System.out.println(clave + " " + figura.get(clave));
		}
		
		//--------
		
		//HashMap		-Recorro la coleccion a traves de key o orden
		//LinkedHashMap	-Recorro la coleccion a traves key, por orden de inserccion
		//TreeMap		-Recorro la coleccion a traves de key, por orden comparable
		
		//.binarySearch para buscar
	}
}
