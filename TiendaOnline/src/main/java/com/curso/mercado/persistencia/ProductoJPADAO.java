package com.curso.mercado.persistencia;

import java.sql.Connection;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.curso.mercado.entidades.Producto;

public class ProductoJPADAO implements GenericDAO<Producto> {

	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("OracleHRPU");
	}
	
	EntityManager em = factory.createEntityManager();
	
	@Override
	public void add(Producto p) {
		try {
			em.getTransaction().begin(); 
			em.persist(p); 
			em.getTransaction().commit();
			System.out.println("Se ha grabado el prducto con JPA");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se ha podido añadir el producto");
			em.getTransaction().rollback();
		} 		
	}

	@Override
	public List<Producto> getAll() {
		Query consulta = em.createQuery("SELECT p FROM Producto p");
		List<Producto> lista = consulta.getResultList();
		System.out.println("Se ha mostrado la lista con JPA");
		return lista;
	}

	@Override
	public Producto getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Producto entidad) {
		// TODO Auto-generated method stub
		
	}

}
