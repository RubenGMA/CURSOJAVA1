package com.curso.spring.repositorio;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.curso.spring.entidades.Pedido;

@Repository //anotacion repositorio
@Qualifier("pedidoRepo")
public class PedidoRepositoryImp implements PedidoRepository {

	private static Logger log = LoggerFactory.getLogger(PedidoRepositoryImp.class);
	
	private static Map<Integer,Pedido> pedidos = new HashMap<Integer,Pedido>();
	private static int id;
	
	//para tener productos ya, esto si hay base de datos no se hace
	//simula una base de datos en memoria ram.
	static {
		//añado dos pedidos
		pedidos.put(1, new Pedido(1, "Luis", "Television",new Date(), true));
		pedidos.put(2, new Pedido(2, "Luis", "Libro",new Date(), true));
		pedidos.put(3, new Pedido(3, "Maite", "Moto",new Date(), true));
		id = 3;
	}
	
	public PedidoRepositoryImp() {
		log.info("... instanciando PedidosRepositoryImp");
	}
		
	
	@Override
	public void add(Pedido pedido) {
		id++;
		pedido.setId(id);
		pedidos.put(id, pedido);
		log.info("... Has grabado un pedido en la base de datos");		
	}


	@Override
	public Collection<Pedido> getPedidosByUser(String user) {
		Collection<Pedido> lista = new ArrayList();
		for(Pedido p: pedidos.values()) {
			if(p.getUser().equals(user)) {
				lista.add(p);
			}
		}
		log.info(lista.toString());
		return lista;
	}

}
