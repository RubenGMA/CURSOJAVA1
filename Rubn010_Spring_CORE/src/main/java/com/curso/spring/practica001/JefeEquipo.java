package com.curso.spring.practica001;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="jefe1")
public class JefeEquipo implements Gestor{

	private int equipo;
	
	
	@Autowired
	//@Qualifier("programadorJava")  //inyeccion
	private Recurso recurso;
	
	public JefeEquipo() {
		System.out.println("construyendo jefe de equipo");
		equipo=1;
		System.out.println("El recurso es: " + recurso);//aqui todavia no se ha cargado el recurso con el autowired, se usan en el postconstruct
	}
	
	public JefeEquipo(int equipo, Recurso recurso) {
		this.equipo = equipo;
		this.recurso = recurso;
	}
	
	@Override
	public void gestionar() {
		System.out.println("gestionar");		
	}
	
	@PostConstruct //despues del contructor
	public void inicio() {
		System.out.println("... postConstruct");
		System.out.println("El recurso es: " + recurso);
	}
	
	@PreDestroy //el contenedor de beans le llama cuando se destruye
	public void destruir() {
		System.out.println("Elimino el bean JefeEquipo");
	}

}
