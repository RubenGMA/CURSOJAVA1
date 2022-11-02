package com.curso.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.servicios.PedidosService;

@SpringBootApplication
public class Rubn011SpringBootCoreApplication implements CommandLineRunner{

	@Autowired //autowired
	private PedidosService servicio;
	
	public static void main(String[] args) {
		SpringApplication.run(Rubn011SpringBootCoreApplication.class, args); //es equivalente a otros metodos que usabamos
	}

	@Override
	public void run(String... args) throws Exception {		
		servicio.generarPedido(new Pedido());
	}

}
