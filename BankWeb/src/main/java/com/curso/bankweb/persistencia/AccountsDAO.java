package com.curso.bankweb.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.curso.bankweb.entidades.Bank;
import com.curso.bankweb.entidades.Customer;
import com.curso.bankweb.entidades.Account;

public class AccountsDAO {

	public void add(Customer customer, Account account) {
		//fata validar 
		customer.addAccount(account);     
	}
	
	public Account getByIndex(Customer customer, int index) {
		return customer.getAccount(index);
	}

}