package com.curso.flota.dominio;

public class Caja {
	//Atributos
	private double peso;
	
	// Constructores
 	public Caja() {
	 this.peso = 100.0;
 	}
 	// Metodos
 	public void setPeso(double nuevoPeso){
 		//validar peso > 0
 		if(peso <= 0) {
 			throw new RuntimeException("La caja debe pesar algo");
 		}
 		this.peso = nuevoPeso;
 	}
 	public double getPeso(){
 		return peso;
 	}
}
