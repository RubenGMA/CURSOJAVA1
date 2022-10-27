package com.curso.JPA.pruebas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.curso.JPA.entidades.Departamento;
import com.curso.JPA.entidades.Empleado;

public class PruebaConsultasJPA {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();

//		Departamento d = em.find(Departamento.class, 10);
//		System.out.println("Departamento es: " + d);

		// Query nativa (BD) => SELECT * FROM DEPARTMENTS;
		// JPA Query => SELECT d FROM Departamento d;

//		//MODO 1
//		Query consulta = em.createQuery("SELECT d FROM Departamento d WHERE d.idManager IS NULL");
//		List<Departamento> lista = consulta.getResultList();
//		System.out.println("Lista departamentos");
//		
//		for(Departamento d2 : lista) {
//			System.out.println(d2);
//		}
//		
////		//MODO 2 - NAMED QUERY
//		Query consulta2 = em.createNamedQuery("Departamento.findAll");//las consultas (namedquery) estan en la clase departamento
//		List<Departamento> lista2 = consulta2.getResultList();
//		System.out.println("Lista departamentos con Named Query");
//		
//		for(Departamento d2 : lista2) {
//			System.out.println(d2);
//		}
		
//		//MODO 2 - NAMED QUERY
//		Query consulta3 = em.createNativeQuery("SELECT * FROM DEPARTMENTS",Departamento.class);
//		List<Departamento> lista3 = consulta3.getResultList();
//		System.out.println("Lista departamentos con Native Query");
//		
//		for(Departamento d3 : lista3) {
//			System.out.println(d3);
//		}
		
		//EJECUTAR UNA CONSULTA CON PARAMETROS
		
//		Query qConParam = em.createNamedQuery("Departamento.findByManager");
//		qConParam.setParameter("idManager", 108);
//		
//		List<Departamento> lista4 = qConParam.getResultList();
//		System.out.println("Los departamentos del manager 108 son:");
//		for(Departamento d4 : lista4) {
//			System.out.println(d4);
//		}
		
//		//Select con consulta local jpa
//		String consultaEmpleadoDptLoc1700 = "SELECT e FROM Empleado e WHERE e.departamento.idLocalidad = :idLoc";		
//	
//		int idLocalidad = 1700;
//		Query q = em.createQuery(consultaEmpleadoDptLoc1700);
//		q.setParameter("idLoc", idLocalidad);
//		
//		List<Empleado> listEmp = q.getResultList();
//		System.out.println("Lista empleados depar localidad 1700");
//		for(Empleado e : listEmp) {
//			System.out.println(e);
//		}
		
		//CRITERIA (para que la Query sea dinamica en funcion de los argumentos que me pasen)
		//PANTALLA filtro busqueda / lista resultado de la busqueda
		
		//filtro NOMBRE
		//filtro ID TRABAJO
		//..
		
		String nombre = "Steven";
		String apellido = null;
		String idJob = null;
		Double salario = 999.0;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
		
		//Entidades que quiero recueprar
		Root<Empleado> empleado = cq.from(Empleado.class);
		
		
		//para meter varias cosas al where me creo un objeto tipo predicate
		Predicate miWhere = null;
		List<Predicate> condiciones = new ArrayList();
		
		//si me has pasado un nombre de empleado lo añado en el where
		if(nombre != null) {
			condiciones.add(cb.equal(empleado.get("nombre"), nombre));
		}
		if(apellido != null) {
			condiciones.add(cb.equal(empleado.get("apellidos"), apellido));
		}		
		if(salario != null) {
			condiciones.add(cb.greaterThan(empleado.get("salario"), salario));
		}
		
		//OR JOBID = 'AD_ASST'
		
		
		Predicate todosAnd = cb.and(condiciones.toArray(new Predicate[0]));
		Predicate job = cb.equal(empleado.get("idTrabajo"), "AD_ASST");
		Predicate whereFinal = cb.or(todosAnd,job);
		
		cq.where(whereFinal);		
		
		//definir el WHERE
//		if(condiciones.size()>0) {
//			//convertir Arraylist en un array de Predicate
////			Predicate[] condicionesFinal = new Predicate[condiciones.size()];
////			condiciones.toArray(condicionesFinal);
////			cq.where(condicionesFinal);
//			cq.where(condiciones.toArray(new Predicate[0]));
//		}
		
		//Ejecutar la consulta
		Query qCriteria = em.createQuery(cq);
		List<Empleado> listaEmpleados = qCriteria.getResultList();
		
		System.out.println(".....LOS EMPLEADOS:");
		
		for (Empleado e : listaEmpleados) {
			System.out.printf(" %s %s - Salario: %.2f %n", e.getNombre(), e.getApellidos(), e.getSalario());
		}
		
		
		
		
		
	} // fin main
}
