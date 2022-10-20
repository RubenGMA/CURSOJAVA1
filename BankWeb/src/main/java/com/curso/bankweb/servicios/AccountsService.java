package com.curso.bankweb.servicios;

import java.util.ArrayList;
import java.util.List;

import com.curso.bankweb.entidades.Account;
import com.curso.bankweb.entidades.Customer;
import com.curso.bankweb.persistencia.AccountsDAO;

public class AccountsService {
	AccountsDAO dao = new AccountsDAO();
	public List<Account> dameTodasLasCuentas(Customer c){
		List lista = new ArrayList<>();
		int numberOfAccounts = c.getNumOfAccounts();
		
		for (int i=0; i<numberOfAccounts ;i++) {
	  		lista.add(dao.getByIndex(c, i));	  		
	  	}	
		
		return lista;
	}
}
