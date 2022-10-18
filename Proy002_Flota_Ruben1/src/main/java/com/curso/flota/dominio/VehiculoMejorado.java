package com.curso.flota.dominio;

/**
 * Clase que representa un vehiculo de una flota 
 * Puede transportar cajas
 * Pero tiene carga maxima permitida
 * @author Rubeng
 * @version 1.0
 *
 */
public class VehiculoMejorado {
	
	//atributos
	private double cargaMaxima = 2000;
	protected double cargaActual = 0.0;
	private String matricula = "";
	protected int numCajas = 0;
	
	//asi por convenio se declara una constante:
	//public final double CARGA_MAXIMA_POR_DEFECTO = 5222.78;
	
	//constructores
	public VehiculoMejorado(String matricula, double cargaMaxima) {
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
	public void cargarCaja(double peso) throws CargaException{
		if(peso <= 0) {
			throw new CargaException("La caja debe pesar algo",0);
		}
		if(peso+cargaActual > cargaMaxima) {
			double exceso = cargaMaxima - (peso + cargaActual);
			throw new CargaException("no caben cajas", exceso);
		}
		//puedo cargar
		this.cargaActual += peso;
		this.numCajas ++;
	}
	
	//sobreescribo el método cargarCaja para que permita recibir un objeto Caja
	public void cargarCaja(Caja nuevaCaja) throws CargaException {
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
