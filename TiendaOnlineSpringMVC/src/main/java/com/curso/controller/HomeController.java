package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String inicio(Model model) {
		model.addAttribute("saludo", "Bienvenido a La Tienda Online");
		model.addAttribute("lineal", "Los Mejores Precios");
		return "home"; // nombre de la pagina jsp que se va a renderizar 
		//concatena lo que hay en el servlet context		
	}
	@RequestMapping("/saludo")
	public String saludo(Model model) {
		model.addAttribute("saludo","Bienvenido a la tienda Online!!");
		model.addAttribute("lineal", "Hola a todos");
		return "home";
	}
	
}
