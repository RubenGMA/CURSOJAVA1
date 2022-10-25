package com.curso.JPA.pruebas;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.JPA.entidades.Trabajo;

public class PruebaTrabajoJPA {
	
	public static void main(String[] args) {
		
		//1. Crear una Factoria de Entity Manager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		//2. Obtenemos un entity manager que conecta con HR de Oracle y mapea las clases entiedad.
		EntityManager em = factory.createEntityManager();		
		//3. Obtener el trabajo con el id "AD_VP"
		Trabajo t = em.find(Trabajo.class, "AD_VP");
		if(t == null) {
			System.out.println("No se ha encontrado el trabajo");
		}else {
			System.out.println(t);
		}
		
		
		//4. Crear nuevo trabajo
		Trabajo tNuevo = new Trabajo("BE_OL","Tareas Super Dificiles",33000.0,53000.0);
		em.getTransaction().begin(); //Inicia nueva transaccion
//		em.persist(tNuevo); //insert //para que sincronice con la base de datos
		em.getTransaction().commit(); //Obtiene la transaccion y la confirma
		
		//5. Modificacion
		try {
			//recibo nuevo trabajo mod
			Trabajo tNuevoMod = new Trabajo("BE_OL","Tareas Dificiles",33000.0,53000.0);
			//5.1 Modo 1 - modificar despues de un find
			em.getTransaction().begin(); 
			
			Trabajo tDesdeBD = em.find(Trabajo.class, tNuevoMod.getId());
			tDesdeBD.setTituloTrabajo(tNuevoMod.getTituloTrabajo());
			
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}	
		
		//6. Modificar Modo 2. usando  em.merge
		
		Trabajo tNuevoMod2 = new Trabajo("BE_OL","Tareas Dificiles 2.0",33000.0,53000.0);		
		em.getTransaction().begin(); 
		
		Trabajo trabajoEnBD = em.merge(tNuevoMod2);
		
		em.getTransaction().commit();
		
		//7. Borrar
		em.getTransaction().begin(); 
		
		Trabajo tABorrar = new Trabajo();
		tABorrar.setId("BE_OL");
		//find objeto
		Trabajo tBD = em.find(Trabajo.class, tABorrar.getId());
		//remove
		em.remove(tBD);
		em.getTransaction().commit();
		
		//7. Consulta JPAQuery
		Query consulta = em.createQuery("SELECT t FROM Trabajo t");
		List<Trabajo> lista = consulta.getResultList();
		
		for(Trabajo tr : lista) {
			System.out.println(tr);
		}
		
	}
}
