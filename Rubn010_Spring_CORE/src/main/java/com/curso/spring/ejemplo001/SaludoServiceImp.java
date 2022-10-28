package com.curso.spring.ejemplo001;

import java.util.logging.Logger;

public class SaludoServiceImp implements SaludoService{

	Logger logger = Logger.getLogger("SaludosServiceImp");
	
	private String cabeceraMensaje;
	
	public SaludoServiceImp() {
		logger.info(".........Instanciamos el servicio");
		this.cabeceraMensaje = "Hola";
	}
	
	public SaludoServiceImp(String cabecera) {
		logger.info(".........Instanciamos el servicio");
		this.cabeceraMensaje = cabecera;
	}
		
	@Override
	public void saludar(String mensaje) {
		if(mensaje == null) {
			logger.severe("error gordo");
			throw new IllegalArgumentException("el mensajes es null");
		}
		logger.fine("saludador");
		logger.info(this.cabeceraMensaje + mensaje + "!!");
		
	}

}
