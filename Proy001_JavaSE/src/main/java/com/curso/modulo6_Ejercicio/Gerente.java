package com.curso.modulo6_Ejercicio;

public class Gerente extends Empleado {
	private String departamento;
	
	public String getDetails() {
		return getNombre() + " tiene salario " + 
				getSalario() + "y departamento" + departamento;
	}
}
