package com.curso.modulo7;

public class TestCounter {
	
	public static void main(String[] args) {
		
		//se puede llamar a la variable counter sin crear instancia del objeto.
		
		System.out.printf("counter vale %d %n ", Counter.getCounter());
		//crear 3 objetos Counter
		//ver sus serial numbers
		//y ver lo que vale ahora counter
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		//Counter.getCounter() = 9;
		Counter c3 = new Counter();
		
		System.out.printf("c1 %d, c2 %d, c3 %d %n", 
				c1.getSerialNumber(),
				c2.getSerialNumber(),
				c3.getSerialNumber());
	}
}
