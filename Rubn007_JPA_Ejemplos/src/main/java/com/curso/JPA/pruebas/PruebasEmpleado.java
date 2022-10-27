package com.curso.JPA.pruebas;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.JPA.entidades.Empleado;
import com.curso.JPA.entidades.Trabajo;
import com.curso.JPA.entidades.Departamento;

public class PruebasEmpleado {
	public static void main(String[] args) {
		
		//1. crear la factoria entitymanager
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		//2. crear un EM
		EntityManager em = factory.createEntityManager();	
		//2.1 Comprobar con una consulta que funciona
//		Long id = (long) 131;
//		Empleado e = em.find(Empleado.class, id);
//		if(e == null) {
//			System.out.println("No se ha encontrado el empleado");
//		}else {
//			System.out.println(e);
//		}	
		
		//3. crear una transaccion	
		em.getTransaction().begin();
		//4. crear un empleado nuevo		
		try {				
		Empleado eNuevo = new Empleado();		
		eNuevo.setNombre("lolo");
		eNuevo.setApellidos("Perez");
		eNuevo.setFechaContratacion(new Date());
		Departamento d = new Departamento();
		d.setId(10);
		eNuevo.setDepartamento(d);	
		
		eNuevo.setIdTrabajo("ST_MAN");
		eNuevo.setEmail("luis@gmail.es");
		
		//5. persistir
			em.persist(eNuevo); 
			System.out.println("se va a insertar empleado con ID " + eNuevo.getId());
			em.getTransaction().commit();
		} catch (Exception e1) {
			e1.printStackTrace();
			em.getTransaction().rollback();
			System.out.println("No se ha podido insertar");
		} 
		//6. confirmar transaccion si ok, rollback si fallo.
		
	}
}
