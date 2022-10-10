package com.curso.modulo6_Ejercicio;

import java.util.Date;

public class Empleado {
	private String nombre;
	private double salario;
	private Date fechaNacimiento;

	
	public Empleado() {
		super();
	}

	public String getDetails() {
		return nombre + " tiene salario " + salario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}





