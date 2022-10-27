package com.curso.JPA.pruebas;

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

public class PriebasCriteria {
	public static void main(String[] args) {
		// 1. Usando criteriaBuilder
		// Obtener todos los departamentos
		// por lo calidad or maganer
		// condicion localidad y manager es opcional

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
		EntityManager em = factory.createEntityManager();

		String idLocalidad = null;
		String idManager = null;

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Departamento> cq = cb.createQuery(Departamento.class);

		// FROM
		Root<Departamento> departamento = cq.from(Departamento.class);

		// CONDICIONES
		Predicate condicionLoc = null;
		Predicate condicionManager = null;

		if (idLocalidad != null) {
			condicionLoc = cb.equal(departamento.get("idLocalidad"), idLocalidad);
		}
		if (idManager != null) {
			condicionManager = cb.equal(departamento.get("idManager"), idManager);
		}
		Predicate condicionFinal = null;
		
		if(condicionLoc != null & condicionManager != null) {
			condicionFinal =cb.or(condicionLoc, condicionManager);
		}else if(condicionLoc != null) {
			condicionFinal = condicionLoc;
		}else if (condicionManager != null) {
			condicionFinal = condicionManager;
		}
		
		
		// WHERE
		if (condicionFinal != null)
			cq.where(condicionFinal);

		// FINAL
		Query qCriteria = em.createQuery(cq);
		List<Departamento> listaDepart = qCriteria.getResultList();

		System.out.println(".....LOS DEPARTAMENTOS:");
		for (Departamento d : listaDepart) {
			System.out.printf(" %s %d %n", d.getNombreDepartamento(),d.getIdLocalidad());
		}
	}
}
