package com.curso.modulo6;

import java.util.Date;

public class Empleado {
	
	private static final double SALARIO_BASE = 15000.0;
	private String nombre;
	private double salario;
	private Date fechaNacimiento;
	
	//constructores	
	
	
	//metodos
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
