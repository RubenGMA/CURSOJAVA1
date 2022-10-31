package com.curso.spring.practica001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curso.spring.ejemplo002.NominaService;

public class Prueba {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("gestion.xml");
		JefeEquipo je= (JefeEquipo) ctx.getBean("jefe1");
		
	}

}
