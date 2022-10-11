package com.mybank.domain;
/**
 * 
 * @author RubenG
 *
 */
public class Customer {
	
	//atributos
	private String firstName;
	private String lastName;
	private Account account;
		
	//construcotres
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
	}
	//metodos

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
		
}
