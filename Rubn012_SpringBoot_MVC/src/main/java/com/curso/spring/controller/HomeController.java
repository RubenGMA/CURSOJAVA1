package com.curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.curso.spring.entidades.Usuario;


@Controller
@SessionAttributes("usuario")
public class HomeController {

	@GetMapping("/") //por defecto es modo get ya.
	public String inicio(Model model) {
		Usuario usr = (Usuario) model.getAttribute("usuario");
		if(usr.getNombre()  == null){
			return "redirect:/login";
		}else {
			return "home";
		}
	}
	
}
