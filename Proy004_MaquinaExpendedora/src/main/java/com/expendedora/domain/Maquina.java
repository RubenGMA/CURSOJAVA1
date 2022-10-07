package com.expendedora.domain;

/**
 * Maquina de refrescos con capacidad de 5 tipos de refresco diferente y 100 centimos en cambios
 * @author ALUMNO
 *
 */
public class Maquina {
	//atributos
	private int cantidadRefrescos = 5;
	private int cambios;
	private Refresco[] refrescos;
	private int ventasTotal;
	
	//constructor
	public Maquina() {
		super();
		this.cambios = 100;
		this.ventasTotal = 0;
		refrescos = new Refresco[this.cantidadRefrescos];
		Refresco r1 = new Refresco("Naranja", 250, 1, 2 );
		Refresco r2 = new Refresco("Fresa", 250, 1, 3 );
		Refresco r3 = new Refresco("Limon", 250, 1, 4 );
		Refresco r4 = new Refresco("Chocolate", 250, 1, 1 );
		Refresco r5 = new Refresco("Sandia", 250, 1, 6 );
		refrescos[1] = r1; refrescos[2] = r2; refrescos[3] = r3; 
		refrescos[4] = r4; refrescos[5] = r5;
	}
	
	//metodos
	public void reponer(int i, int cantidad) {
		this.refrescos[i].stock = this.refrescos[i].stock + cantidad;
	}

	public void venderRefresco(int i) {
		if(!this.refrescos[i].agotado) {
			this.refrescos[i].stock = this.refrescos[i].stock - 1;
			this.ventasTotal++;
		}
	}
	
	public int mostrarInformeVentas() {
		return this.ventasTotal;
	}
	
	public boolean comprobarSiAgotado(Refresco r) {
		return r.agotado;
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

	
}
