package com.mybank.pruebas;

import com.mybank.domain.Account;
import com.mybank.domain.Customer;

public class TestBanking {
	public static void main(String[] args) {
		boolean res;
		try {
			Customer c = new Customer("Luis", "Ramos");
			System.out.printf("Creando el cliente  %s %s %n", 
					c.getFirstName(), 
					c.getLastName());
			Account a = new Account(500);
			c.setAccount(a);
			System.out.printf("Creando su cuenta bancario con saldo %f . %n", 
					a.getBalance());
			double retirar = 150;
			double ingresar = 22.50;
			res =  c.getAccount().withdraw(retirar);
			System.out.println("sacar " + retirar +": " + res);
			res =  c.getAccount().deposit(ingresar);
			System.out.println("ingresar " + ingresar +": " + res);
			System.out.println("Customer [" + c.getLastName() + ", "+ c.getFirstName()+"] "
					+ "tiene un saldo "
					+ "de " + c.getAccount().getBalance());
			
		
		}catch (Exception e) {
			System.out.println("No pudo cargar ");
		}
	}	
}
