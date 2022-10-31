package com.curso.spring.configuracion;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component(value="jefe1")
public class JefeEquipo implements Gestor{

	private int equipo;
	
	@Resource(name = "programadorJava")
	//@Autowired
	//@Qualifier("programadorJava")  //inyeccion
	private Recurso recurso;
	
	public JefeEquipo() {
		System.out.println("construyendo jefe de equipo");
		equipo=1;
	}
	
	public JefeEquipo(int equipo, Recurso recurso) {
		this.equipo = equipo;
		this.recurso = recurso;
	}
	
	@Override
	public void gestionar() {
		System.out.println("GESTIONO EL EQUIPO" + equipo);		
		System.out.println("EL RECURSO TRABAJA:");
		recurso.trabajar();
	}
	
	@PostConstruct //despues del contructor
	public void inicio() {
		System.out.println("... postConstruct");
	}
	
	@PreDestroy //el contenedor de beans le llama cuando se destruye
	public void destruir() {
		System.out.println("Elimino el bean JefeEquipo");
	}

}
