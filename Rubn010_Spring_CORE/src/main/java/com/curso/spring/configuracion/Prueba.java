package com.curso.spring.configuracion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.spring.ejemplo002.NominaService;

public class Prueba {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurarBeansApp.class);
		Gestor servicio= (Gestor) ctx.getBean("jefe1"); //nombre del metodo en ConfigurarBeansApp.java
		
		servicio.gestionar();
	}

}
