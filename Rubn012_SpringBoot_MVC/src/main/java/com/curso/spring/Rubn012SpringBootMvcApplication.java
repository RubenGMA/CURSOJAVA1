package com.curso.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.servicios.PedidosService;

@SpringBootApplication
public class Rubn012SpringBootMvcApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(Rubn012SpringBootMvcApplication.class, args);
	}
	

}
