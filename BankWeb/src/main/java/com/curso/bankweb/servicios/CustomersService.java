package com.curso.bankweb.servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.curso.bankweb.entidades.Customer;
import com.curso.bankweb.persistencia.CustomersDAO;
import com.curso.bankweb.persistencia.GenericDAO;


public class CustomersService {
	GenericDAO<Customer> dao = new CustomersDAO();
	
	public List<Customer> dameTodosLosClientes(){
		Customer[] customers = dao.getAll();
		List lista = new ArrayList();
		lista = Arrays.asList(customers);
		return lista;
	}
}
