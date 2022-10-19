package com.curso.mercado.servicios;

import java.util.List;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.persistencia.GenericDAO;
import com.curso.mercado.persistencia.ProductoInMemoryDAO;
import com.curso.mercado.servicios.excepciones.VentasException;

public class VentasService {
	private GenericDAO<Producto> productDAO = new ProductoInMemoryDAO();
	
	public void comprarProducto(int id, int cantidad) throws VentasException{
		
		//caso1 si comprar un producto que no existe lanzo una excepcion.
		Producto pAVender = productDAO.getByID(id);
		if (productDAO.getByID(id) == null) {
			throw new VentasException("No esxiste el producto con id: " + id);
		}
		
		//caso 2 no hay stock suficiente
		if(pAVender.getStock() < cantidad) {
			throw new VentasException("No hay stock suficiente");
		}
		//caso 3 hay stock y se resta la cantidad.
		pAVender.setStock(pAVender.getStock() - cantidad);
	}
	
	public List<Producto> listaProductoVenta(){
		return productDAO.getAll();
	}
	
}
