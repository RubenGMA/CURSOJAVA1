package com.curso.spring.restcontroller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.servicios.PedidosService;

@RestController
public class PedidosRestFullController {
		
		@Autowired
		private PedidosService pedidosService;
		
		//GET ALL
		@GetMapping("/ws/pedidos")
		public Collection<Pedido> all(){
			return pedidosService.getPedidos(null);
		}
		
		//GET BY ID
		@GetMapping("/ws/pedidos/{id}")
		public Pedido byId(
			@PathVariable("id") int id){
			return pedidosService.getPedido(id).get();
		}
		//INSERT
		@PostMapping("/ws/pedidos")
		public Pedido add(@RequestBody Pedido newPedido) {
			//{"user":"4","desc":"Rosas de prueba","fechaPedido":"2022-11-04T12:16:01.351+00:00","entregado":true}
			Pedido p = pedidosService.generarPedido(newPedido);			
			return p;
		}
		//DELETE
		@DeleteMapping("/ws/pedidos/{id}")
		public Pedido deletebyId(@PathVariable int id){
			return pedidosService.getPedido(id).get();
		}
		//UPDATE
		@PutMapping("/ws/pedidos")
		public Pedido update(@RequestBody Pedido newPedido) {
			Pedido pmodif = pedidosService.modificarPedido(newPedido);
			return pmodif;
		}
}
