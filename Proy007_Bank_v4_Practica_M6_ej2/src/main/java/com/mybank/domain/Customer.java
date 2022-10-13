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
	private Account[] accounts;
	private int numberOfAccounts;
	
	//construcotres
	public Customer(String f, String l) {
		this.firstName = f;
		this.lastName = l;
		this.numberOfAccounts = 0;
	}
	//metodos

	public Account getAccount(int i) {
		return accounts[i];
	}

	public void addAccount(Account account) {
		this.accounts[this.numberOfAccounts] = account;
		this.numberOfAccounts++;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
		
}
