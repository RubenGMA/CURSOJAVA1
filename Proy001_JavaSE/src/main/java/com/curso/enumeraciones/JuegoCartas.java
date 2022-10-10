package com.curso.enumeraciones;

public class JuegoCartas {
	public static void main(String[] args) {
		Carta c1 = new Carta(Palos.OROS, 2);
		
		//nombre
		System.out.println(Palos.OROS);
		//posicion dentro de la enumeracion
		System.out.println(Palos.OROS.ordinal());
		
		Palos[] valores = Palos.values();
		
		System.out.println("...los palos son ");
		for(Palos p: valores) {
			System.out.println(p);
		}
		
		if(c1.getPalo() == Palos.OROS) {
			System.out.println("...eres el mejor");
		}
	}
}
