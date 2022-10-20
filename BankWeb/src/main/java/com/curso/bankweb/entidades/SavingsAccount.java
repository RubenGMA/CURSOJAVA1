package com.curso.bankweb.entidades;

public class SavingsAccount extends Account {
    
    private double interestRate;
    
    public SavingsAccount(double initBalance, double interestRate) {
        super(initBalance);
        this.interestRate = interestRate;
    }
    
    public void accumulateInterest() {
        balance += (balance * interestRate);
    }    
}
