package com.curso.bankweb.entidades;

import java.util.List;
import java.util.TreeMap;
  
public class Bank {
  private static Customer[] customers;
  private static int        numberOfCustomers;

  static {
    customers = new Customer[10];
    numberOfCustomers = 0;
    Bank.addCustomer("Luengo", "Maria");
    Bank.addCustomer("Gonzalez", "Luis");
    Bank.addCustomer("Perez", "Jose");
	Bank.getCustomer(0).addAccount(new CheckingAccount(300.0, 450.0));
	Bank.getCustomer(0).addAccount(new SavingsAccount(25.0, 0.05));
	Bank.getCustomer(1).addAccount(new SavingsAccount(780.0, 0.05));
	Bank.getCustomer(2).addAccount(new SavingsAccount(379.0, 0.05));	
  }

  private Bank() {
    // this constructor should never be called
  }

  public static void addCustomer(String f, String l) {
    int i = numberOfCustomers++;
    customers[i] = new Customer(f, l);
  }
  public static int getNumOfCustomers() {
    return numberOfCustomers;
  }
  public static Customer[] getAll() {
	  	int numberOfCustomers = Bank.getNumOfCustomers();
	  	Customer[] lista = new Customer[numberOfCustomers];
	  	for (int i=0; i<numberOfCustomers ;i++) {
	  		lista[i] = customers[i];	  		
	  	}	  	
	    return lista;
	  }
  
  public static Customer getCustomer(int customer_index) {
    return customers[customer_index];
  }
}
