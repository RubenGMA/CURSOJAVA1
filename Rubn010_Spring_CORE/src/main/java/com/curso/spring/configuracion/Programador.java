package com.curso.spring.configuracion;

import java.util.Objects;

import org.springframework.stereotype.Component;

//@Component //sin anotaciones, por que ya hay un configuration bean
public class Programador implements Recurso{

	private String tarea;
	
	public Programador() {
		tarea = "Programar";
	}
	
	@Override
	public void trabajar() {
		System.out.println("REALIZO LA TAREA: " + tarea);		
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	@Override
	public String toString() {
		return "Programador [tarea=" + tarea + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(tarea);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programador other = (Programador) obj;
		return Objects.equals(tarea, other.tarea);
	}

}
