package com.mybank.domain;
/**
 * 
 * @author RubenG
 *
 */
public class SavingsAccount extends Account {
	//variables
    private double interestRate;
    //constructor
    public SavingsAccount(double initBalance, double interestRate) {
        super(initBalance);
        this.interestRate = interestRate;
    }
}
