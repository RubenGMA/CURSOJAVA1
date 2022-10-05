package com.curso.modulo4;

import java.util.Date;

public class PruebaPedido {
	
	public static void main(String[] args) {
		//dos posibles formas de crear ibj Producto.
		Pedido p = new Pedido(1);
		
		p.setCantidad(10);
		p.setIdPedido(45);
		p.setFechaPedido(new Date());
		p.setObservaciones("urge");
		
		System.out.println(p);
		Pedido p2 = p;
		System.out.println(p2); //esta variable apunta al mismo objeto
		
		System.out.println(p2.getIdPedido());
	}
}
