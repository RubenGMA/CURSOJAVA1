package com.curso.bankweb.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.curso.bankweb.entidades.Bank;
import com.curso.bankweb.entidades.Customer;

public class CustomersDAO implements GenericDAO<Customer> {

	
	@Override
	public void add(Customer entidad) {
		Bank.addCustomer(entidad.getFirstName(),entidad.getLastName());	        
	}

	@Override
	public Customer[] getAll() {		
		return Bank.getAll();
	}
	
	@Override
	public Customer getByIndex(int index) {
		return Bank.getCustomer(index);
	}

}