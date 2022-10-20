package com.curso.bankweb.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.bankweb.entidades.Customer;
import com.curso.bankweb.servicios.CustomersService;


public class ListaClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ListaClientesServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomersService service = new CustomersService();
		List<Customer> lista = service.dameTodosLosClientes();

		// añadir el atributo lista con todos los productos a la request
		request.setAttribute("lista", lista);

		// despachar la peticion a lista-productod.jsp
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}


}
