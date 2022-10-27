package com.curso.JPA.pruebas;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.JPA.entidades.Customer;
import com.curso.JPA.entidades.Order;


public class PruebaOneToMany {
	
	public static void main(String[] args) {
		//1. crear la factoria entitymanager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		//2. crear un EM
		EntityManager em = factory.createEntityManager();
		
		//3. crear una cliente con una orden
		
//		Order pedido = new Order();	
//		Customer c7 = new Customer();
//		c7.setId(7);
//		
//		pedido.setCustomer(c7);
//		pedido.setDescription("Pedido importante");
//		
//		em.getTransaction().begin();
//		em.persist(pedido);
//		em.getTransaction().commit();	
		
		Order o = em.find(Order.class, 10);
		System.out.printf("el pedido %s ha sido hecho por %s %n" ,o.getDescription() ,o.getCustomer().getCustomerName() );
		
		Order o2 = em.find(Order.class, 9); //no hace la select de nuevo, por que está ya en memoria
		System.out.printf("el pedido %s ha sido hecho por %s" ,o2.getDescription() ,o2.getCustomer().getCustomerName() );
		
		Customer c = em.find(Customer.class, 7);		
		for (Order or: c.getPedidos()) {
			System.out.println(or.getDescription());
		}
		
	}
			
}
