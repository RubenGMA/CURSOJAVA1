package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductosService;
import com.curso.mercado.servicios.VentasService;
import com.curso.mercado.servicios.excepciones.VentasException;


public class VentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VentasServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leer parametro que reciben el idproducto
		String paramId = request.getParameter("idProducto");
		int idProductoComprar = 0;
		if(paramId != null) {
			idProductoComprar = Integer.parseInt(paramId); //falta controlar excepcion
		}
		//comprar 1 unidad
		
		VentasService servicio = new VentasService();
		String mensaje = "";
		try {
			servicio.comprarProducto(idProductoComprar, 1);
			//COMPRA OK
			mensaje = "Has comprado una unidad de " + idProductoComprar ;
			//volver a la lista
		} catch (VentasException e) {
			mensaje = "No se ha comprado. " + e.getMessage();
			//crear atributo mensaje que indique que ha pasado.
			//volver a la lista y que lista muestre el error.
		}
		request.setAttribute("mensaje", mensaje);
		//despachar a lista
				
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaproductos");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
