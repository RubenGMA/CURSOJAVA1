package com.curso.flota.dominio;

import java.util.Date;

public interface Reservable {
	//los metodos de una interfaz son public abstract aunque no lo pongamos
	public void reservar(Date fechaReserva);
}
