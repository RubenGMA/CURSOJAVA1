package com.curso.spring.practica001;

import org.springframework.stereotype.Component;

@Component
public class Programador implements Recurso{

	private String tarea;
	
	public Programador() {
		tarea = "Programar";
	}
	
	@Override
	public void trabajar() {
		System.out.println("REALIZO LA TAREA" + tarea);		
	}

}
