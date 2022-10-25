package com.curso.JPA.pruebas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaTrabajoJPA {
	
	public static void main(String[] args) {
		
		//1. Crear una Factoria de Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		//2. Obtenemos un entity manager que conecta con HR de Oracle y mapea las clases entiedad.
		EntityManager em = factory.createEntityManager();
		
	}
}
