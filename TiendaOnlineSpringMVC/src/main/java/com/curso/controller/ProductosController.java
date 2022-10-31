package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.curso.entidades.Producto;

@Controller
public class ProductosController {
	
	@RequestMapping("/producto")
	public String producto(Model model) {
		Producto p = new Producto();
		p.setIdProducto(1);
		p.setDescripcion("Zapato");
		p.setStock(22);
		p.setPrecio(52.5);
		model.addAttribute("producto",p);
		return "producto";
	}
}
