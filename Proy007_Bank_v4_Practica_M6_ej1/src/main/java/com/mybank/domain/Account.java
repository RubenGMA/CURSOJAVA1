package com.mybank.domain;
/**
 * 
 * @author RubenG
 *
 */
public class Account {

	//atributos
	protected double balance;

	
	//construcotres
	
	protected Account(double initBalance) {
		this.balance = initBalance;
	}
	
	//metodos


	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amt) {
		this.balance = this.balance + amt;
		return true;
	}
	
	public boolean withdraw(double amt) {
		if(this.balance - amt > 0) {
			this.balance = this.balance - amt;
			return true;
		}else {
			return false;
		}
	}
	
}
