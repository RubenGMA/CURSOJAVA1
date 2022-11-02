package com.curso.spring.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.entidades.Usuario;
import com.curso.spring.repositorio.PedidoRepositoryImp;
import com.curso.spring.servicios.PedidosService;

@Controller
@SessionAttributes("usuario")
public class PedidosController {
	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);
	
	@Autowired
	private PedidosService pedidoService;
	
	@GetMapping("/pedidos")
	public String pedidos(Model model) {
		//pedir la lista de pedidos del usuario que esté en sesion
		Usuario usuario = (Usuario) model.getAttribute("usuario");
		String usr = usuario.getNombre(); 
		log.info("El usuario es: " + usr);
		Collection<Pedido> lista = pedidoService.getPedidos(usr);
		model.addAttribute("listaPedidos", lista);
		return "pedidos";
	}
}
