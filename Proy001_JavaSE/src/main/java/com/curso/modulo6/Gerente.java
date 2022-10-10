package com.curso.modulo6;

public class Gerente extends Empleado{
	
	//atributos = todods los del padre + suyos
	private String Departamento;
	
	private String getDepartamento() {
		return Departamento;
	}
	
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}
}