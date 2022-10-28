package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.mercado.entidades.Usuario;
import com.curso.mercado.persistencia.ProductoJPADAO;

//@WebServlet(urlPatterns = "login", loadOnStartup = 1)

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
    	 super();
    	 System.out.println(".... instanciando LoginServlet");       
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	//contexto de la aplicacion
    	// CREO UN ATRIBUTO DE AMBITO DE APLICACION
    	// es para todos los usuarios/paginas/servlets etc
    	System.out.println(".... ServletContext" + config.getServletContext());
    	config.getServletContext().setAttribute("tituloTienda", "LAS MARAVILLAS");
    	
    	//PRUEBA
    	System.out.println("probando si esta bien la configuracion de persistencia");
    	new ProductoJPADAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String rol = request.getParameter("rol");
		
		if(nombre == null || nombre.trim().length()==0) {
			nombre = "inivitado";
		}
		if(rol == null || rol.trim().length()==0) {
			rol = "cliente";
		}		
		Usuario usuario = new Usuario(nombre, rol);
		//modo 1. AMBITO LOCAL (se pierde)
		request.setAttribute("usuario", usuario);
//		RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); 
//		rd.forward(request, response);
		
		//modo 2. AMBITO DE SESION
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("usuario", usuario);
		//sesion.isNew();
		//sesion.invalidate();
		//sesion.setMaxInactiveInterval(20000); //segundos
		
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
