package com.curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/") //por defecto es modo get ya.
	// @RequestMapping(method = RequestMethod.GET, path = "/") //antiguo
	public String inicio(Model model) {
		model.addAttribute("nombre","Luis Ramos");
		return "home";
	}
	
}
