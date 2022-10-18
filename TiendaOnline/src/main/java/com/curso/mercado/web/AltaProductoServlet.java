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


public class AltaProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductosService productoService = new ProductosService();
	
    public AltaProductoServlet() {
        super();
        System.out.println(".... instanciando AltProductoServlet");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".... estoy en el doPost");
		String paramDescripcion = request.getParameter("nombreProducto");
		String paramPrecio = request.getParameter("precioUnidad");
		//validar parametros
		String msgError = "";
		if(paramDescripcion == null || paramDescripcion.trim().length() == 0) {
			msgError = "Debes indicar un nombre para el producto";
		}
		double precio = 0;
		if(paramPrecio == null || paramPrecio.trim().length() == 0) {
			msgError = "Debes indicar un precio para el producto";
		}else {
			precio = Double.parseDouble(paramPrecio); //falta controlar excepcion
		}
		
		if(msgError.length()>0) {
			System.out.println("fallo: " + msgError);
			//response.getWriter().append("error " + msgError);
			request.setAttribute("error", msgError);
			//despache la pagina alta-producto
			RequestDispatcher rd = request.getRequestDispatcher("alta-producto.jsp"); 
			//si hay un error vuelve a la pagina alta prodicto
			rd.forward(request, response);
		}else {
			Producto p = new Producto(null, paramDescripcion, precio);
			System.out.println("vamos a dar de alta "+ p);
			productoService.darAtaUnProducto(p);
			//despache la pagina lista-productos
			List<Producto> listaProductos = productoService.dameTodosLosProductos();
			
			request.setAttribute("lista", listaProductos);
			RequestDispatcher rd = request.getRequestDispatcher("lista-productos.jsp"); 
			rd.forward(request, response);
		}
		
	}//fin del do post
}
