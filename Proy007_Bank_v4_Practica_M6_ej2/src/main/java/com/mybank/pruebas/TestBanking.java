package com.mybank.pruebas;
import com.mybank.domain.Account;
import com.mybank.domain.Bank;
import com.mybank.domain.CheckingAccount;
import com.mybank.domain.Customer;
import com.mybank.domain.SavingsAccount;

/**
 * 
 * @author RubenG
 *
 */

public class TestBanking {
	public static void main(String[] args) {
		Bank bank = new Bank();
	    Customer customer;
	    Account account;
	    
		System.out.println("Creando cliente Jane Smith.");
	    bank.addCustomer("Jane", "Simms");
	    customer = bank.getCustomer(bank.getNumberOfCustomers()-1);
	    System.out.println("Creando su Savings Account con 500.00 y 3% de interes.");
	    customer.addAccount(new SavingsAccount(550.00, 0.03));
	    
	    System.out.println("Creando cliente Owen Bryant");
	    bank.addCustomer("Owen", "Bryant");
	    customer = bank.getCustomer(bank.getNumberOfCustomers()-1);
	    System.out.printf("Creando su Checking Account con 500.00 y 0 de credito.");
	    customer.addAccount(new CheckingAccount(490.00));
	   
	    System.out.println("Creando cliente Tim Soley.");
	    bank.addCustomer("Tim", "Soley");
	    customer = bank.getCustomer(2);
	    System.out.println("Creando su Checking Account con 500.00 y 500.00 de credito.");
	    customer.addAccount(new CheckingAccount(700.00, 400.00));

	    System.out.println("Creando cliente Maria Soley.");
	    bank.addCustomer("Maria", "Soley");
	    customer = bank.getCustomer(bank.getNumberOfCustomers()-1);
	    System.out.println("Maria comparte Checking Account con su marido Tim.");
	    customer.addAccount(bank.getCustomer(bank.getNumberOfCustomers()-2).getAccount(0));
	    
	    // probando la cuenta de Owen Bryant sin credito
	    System.out.println("Transacciones de Owen Bryant con su checking account sin credito.");
	    customer = bank.getCustomer(1);
	    account = customer.getAccount(0);
	    // transacciones
	    System.out.println("Retirar 150.00: " + account.withdraw(150.00));
	    System.out.println("Depositar 22.50: " + account.deposit(22.50));
	    System.out.println("Retirar 450.00: " + account.withdraw(450.00));
	    // Print out the final account balance
	    System.out.println("El cliente [" + customer.getLastName() + ", " + customer.getFirstName()
			       + "] tiene un balance de " + account.getBalance());

	    System.out.println();
	    
	    
	    System.out.printf("%n%n CLIENTES EN EL BANCO %n");
	    for(int i = 0; i< bank.getNumberOfCustomers() ;i++) {
	    	Customer c = bank.getCustomer(i);
	    	System.out.println(" " + c.getFirstName() + " "+ c.getLastName() + " - Balance: " + 
	    						c.getAccount(0).getBalance());
	    }	    
	}	
}
