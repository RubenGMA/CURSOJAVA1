package com.curso.spring.servicios;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.curso.spring.entidades.Pedido;
import com.curso.spring.repositorio.PedidoRepository;
import com.curso.spring.repositorio.PedidoRepositoryImp;

@Service //anotacion servicio
// @Scope(value="singleton") //esto esta por defecto aunque no se ponga nada
// @Lazy //Para que no lo instancie en el arranque
public class PedidoServiceImp implements PedidosService {

	private static Logger log = LoggerFactory.getLogger(PedidoServiceImp.class);
	
	@Autowired
	@Qualifier("pedidoRepo")
	private PedidoRepository repo;
	
	
	public PedidoServiceImp() {
		log.info("... Instanciando PedidoServiceImp" + repo);
	}
	
	@PostConstruct
	private void init() {
		log.info("... postConstruct" + repo);

	}
	
	@Override
	public void generarPedido(Pedido p) {
		
		log.info("... gestiona un pedido");		
		repo.add(p);
		// inventariorepo.update(inventario);
		
	}

	@Override
	public Collection<Pedido> getPedidos(String user) {
		log.info("usuario pedidoServive" + user);
		return repo.getPedidosByUser(user);
	}

}
