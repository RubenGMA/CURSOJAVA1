package com.curso.flota.dominio;

/**
 * Clase que representa un vehiculo de una flota 
 * Puede transportar cajas
 * Pero tiene carga maxima permitida
 * @author Rubeng
 * @version 1.0
 *
 */
public class Vehiculo {
	
	//atributos
	private double cargaMaxima = 2000;
	private double cargaActual = 0.0;
	private String matricula = "";
	private int numCajas = 0;
	
	//asi por convenio se declara una constante:
	//public final double CARGA_MAXIMA_POR_DEFECTO = 5222.78;
	
	//constructores
	public Vehiculo(String matricula, double cargaMaxima) {
		//validar matricula no null para que sea robusto
		//validar carga maxima > 0
		this.matricula = matricula;
		this.cargaMaxima = cargaMaxima;
		
	}
	
	//metodos
	public String getMatricula() {
		return matricula;
	}
	
	public double getCargaMaxima() {
		return cargaMaxima;
	}
	
	public void setCargaMaxima(double cargaMaxima) {
		if (cargaMaxima < 0) { //evitamos que meta un numero negativo
			throw new RuntimeException("No puede pasar una carga negativa"); // excepción se captura sola con runtime
		}
		this.cargaMaxima = cargaMaxima;
	}
	
	/**
	 * Método que recibe el peso de la caja a cargar
	 * e incremetna el peso actual del camión y 
	 * el numero de cajas cargadas,
	 * Si el peso no es valiodo (<0) lanza una excepcion
	 * Si el peso excede...
	 * @param peso peso de la caja a cargar en kg
	 * @throws RuntimeException el peso de la caja no es válido o supera la carga maxima permitida.
	 */
	public void cargarCaja(double peso) {
		if(peso <= 0) {
			throw new RuntimeException("La caja debe pesar algo");
		}
		if(peso+cargaActual > cargaMaxima) {
			throw new RuntimeException("no caben cajas");
		}
		//puedo cargar
		this.cargaActual += peso;
		this.numCajas ++;
	}
	
	//sobreescribo el método cargarCaja para que permita recibir un objeto Caja
	public void cargarCaja(Caja nuevaCaja) {
		cargarCaja(nuevaCaja.getPeso());
	}
	
	public double getCargaActual() {
		//TODO Esto es una tarea pendiente
		return cargaActual;
	}
	
	public int getNumCajas() {
		return numCajas;
	}

}
