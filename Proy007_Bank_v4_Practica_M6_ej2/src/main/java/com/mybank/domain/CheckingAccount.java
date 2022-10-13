package com.mybank.domain;
/**
 * 
 * @author RubenG
 *
 */

public class CheckingAccount extends Account {
	//variables
    private double overdraftAmount;
    //Constructor
    public CheckingAccount(double initBalance, double overdraftAmount) {
        super(initBalance);
        this.overdraftAmount = overdraftAmount;
    }
    //Metodos
    public CheckingAccount(double initBalance) {
        this(initBalance, 0.0);
    }
    
    public boolean withdraw(double amount) {
        boolean r = true;
        
        if ( balance < amount ) {
            // No hay suficiente dinero en la cuenta
            // Mirar si se puede sacar dinero con credito.
            double creditoNecesario = amount - balance;
            if ( overdraftAmount < creditoNecesario ) {
                // No tiene credito suficiente
                r = false;
            } else {
                // Tiene credito suficiente
                balance = 0.0;
                overdraftAmount -= creditoNecesario;
            }
        } else {    
            // Hay suficiente dinero, no hace falta credito
            balance = balance - amount;
        }
        return r;
    }
}
