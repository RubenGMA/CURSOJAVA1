package com.curso.modulo6_Ejercicio;

import java.util.Date;

public class Gerente extends Empleado {
	

	private String departamento;
	
	//constructores
	public Gerente(String nombre, double salario, Date fechaNac,String dpto) {
		super(nombre, salario, fechaNac);
		this.departamento = dpto;
	}


	//metodos
	public String getDetails() {
		return getNombre() + " tiene salario " + 
				getSalario() + " y es gerente del departamento " + departamento;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
