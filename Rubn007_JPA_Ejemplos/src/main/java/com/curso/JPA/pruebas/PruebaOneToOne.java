package com.curso.JPA.pruebas;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.JPA.entidades.Customer;
import com.curso.JPA.entidades.Empleado;
import com.curso.JPA.entidades.Record;
public class PruebaOneToOne {

	public static void main(String[] args) {

		//1. crear la factoria entitymanager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		//2. crear un EM
		EntityManager em = factory.createEntityManager();
		
		//3. crear una transaccion	
		em.getTransaction().begin();
		//4. crear un record
		//crear un cliente que tenga ese record
		//buscar el cliente que acabamos de crear
		//mostrar sus datos y los de su record
				
		Record rec = new Record(null, "REC_UNO");	
		em.persist(rec);
		
		Customer cust = new Customer(null, "MAriio", rec);	
	
		em.persist(cust); 
		int id = cust.getId();
		em.getTransaction().commit();	
		
		System.out.println("Buscar el empleado cuyo id es " + id);
		
		
		Customer cEncontrado = em.find(Customer.class, id);
		if(cEncontrado != null) {
			System.out.printf("El empleado %s tiene record %s ",cEncontrado.getCustomerName() ,cEncontrado.getRecord().getName() );
		}else {
			System.out.println("No se ha encontrado");
		}
	
		//6. confirmar transaccion si ok, rollback si fallo.

	}

}
