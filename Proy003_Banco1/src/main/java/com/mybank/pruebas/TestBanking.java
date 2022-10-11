package com.mybank.pruebas;
/**
 * 
 * @author RubenG
 *
 */
import com.mybank.domain.Account;
import com.mybank.domain.Customer;

public class TestBanking {
	public static void main(String[] args) {
		boolean res;
		double retirar;
		double ingresar;
		try {
			Customer c = new Customer("Luis", "Ramos");
			System.out.printf("Creando el cliente  %s %s %n", 
					c.getFirstName(), 
					c.getLastName());
			Account a = new Account(500);
			c.setAccount(a);
			System.out.printf("Creando su cuenta bancario con saldo %.2f . %n", 
					a.getBalance());
			retirar = 150;
			ingresar = 22.50;
			res =  c.getAccount().withdraw(retirar);
			System.out.println("Sacar " + retirar +": " + res);
			res =  c.getAccount().deposit(ingresar);
			System.out.println("Ingresar " + ingresar +": " + res);
			
			retirar = 47.62;
			res =  c.getAccount().withdraw(retirar);
			System.out.println("Sacar " + retirar +": " + res);
			retirar = 400;
			res =  c.getAccount().withdraw(retirar);
			System.out.println("Sacar " + retirar +": " + res);
			System.out.println("Customer [" + c.getLastName() + ", "+ c.getFirstName()+"] "
					+ "tiene un saldo "
					+ "de " + c.getAccount().getBalance());
			
		}catch (Exception e) {
			System.out.println("No pudo cargar ");
		}
	}	
}
