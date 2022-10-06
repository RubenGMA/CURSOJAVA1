package com.expendedora.domain;

public class Refresco {
	//atributos
	String sabor = "";
	int cl = 170;
	double precio = 0;
	boolean agotado;
	int stock = 0;
	//constructor
	public Refresco(String sabor, int cl, double precio, int stock) {
		super();
		this.sabor = sabor;
		this.cl = cl;
		this.precio = precio;
		this.stock = stock;
		if(stock == 0) {
			this.agotado = true;
		} else {
			this.agotado = false;
		}
	}
	//metodos
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getSabor() {
		return sabor;
	}
	public int getCl() {
		return cl;
	}
	public double getPrecio() {
		return precio;
	}
	public boolean isAgotado() {
		return agotado;
	}
	
	
}
