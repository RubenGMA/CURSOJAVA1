package com.curso.mercado.servicios;

import java.util.List;

import com.curso.db.PoolConexiones;
import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoDBDAO;
import com.curso.mercado.persistencia.ProductoInMemoryDAO;
import com.curso.mercado.persistencia.ProductoJPADAO;

public class ProductosService {
	
	private GenericDAO<Producto> dao;
		 
//	public ProductosService() {
//		PoolConexiones pool = new PoolConexiones();
//		this.dao = new ProductoDBDAO(pool.getConnection());
//	}
	public ProductosService() {		
		this.dao = new ProductoJPADAO();
	}
	public void darAtaUnProducto(Producto p) {
		//validar que p no es null
		//validar descrlipcion
		//validar precio
		dao.add(p);
	}
	
	public List<Producto> dameTodosLosProductos(){
		return dao.getAll();
	}
}
