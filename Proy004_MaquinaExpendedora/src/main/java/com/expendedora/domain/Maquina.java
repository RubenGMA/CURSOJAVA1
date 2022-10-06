package com.expendedora.domain;

/**
 * Maquina de refrescos con capacidad de 5 tipos de refresco diferente y 100 centimos en cambios
 * @author ALUMNO
 *
 */
public class Maquina {
	//atributos
	private int cantidadRefrescos = 0;
	private int cambios;
	private Refresco[] refrescos;
	private int capacidad;
	//constructor
	public Maquina() {
		super();
		this.cambios = 100;
		this.capacidad = 5;
		refrescos = new Refresco[this.capacidad];
		
	}
	
	//metodos
	public void reponer(Refresco r) {
		
	}
	
	public void venderRefresco() {
		
	}

	public int getCantidadRefrescos() {
		return cantidadRefrescos;
	}

	public int getCambios() {
		return cambios;
	}

	public Refresco[] getRefrescos() {
		return refrescos;
	}

	public int getCapacidad() {
		return capacidad;
	}
	
	
}
