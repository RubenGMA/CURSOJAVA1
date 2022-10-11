package com.mybank.domain;
/**
 * 
 * @author RubenG
 *
 */
public class Bank {
	//atributos
	private Customer[] customers;
	private int numberOfCustomers;
	
	//construcotres
	public Bank() {
		super();
		customers = new Customer[20];
		numberOfCustomers = 0;
	}
	//metodos
	
	public void addCustomer(String f, String l) {
		int i = numberOfCustomers++;
		customers[i] = new Customer(f, l);
	}
	
	public Customer getCustomer(int i){
		return customers[i];
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public Customer[] getCustomers() {
		return customers;
	}
	
	
}
