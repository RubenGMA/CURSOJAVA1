package com.curso.modulo7;

public class Counter {
	private int serialNumber;
	private static int counter = 0;
	
	public Counter() {
		counter++;
		serialNumber = counter;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	
	//declaro el metodo static para poder leeer el valor de 
	//la variable statica counter sin necesidad de crar una instancia de la clase.
	public static int getCounter() {
		return counter;
	}
	
	// pruebas en TestCounter
}
