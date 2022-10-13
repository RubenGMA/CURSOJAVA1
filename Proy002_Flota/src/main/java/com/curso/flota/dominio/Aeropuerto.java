package com.curso.flota.dominio;

public class Aeropuerto {
	public void gestionarVuelo(Volable v) {
		v.despegar();
		v.volar();
		v.aterrizar();
	}
	public static void main(String[] args) {
		//la variable de referencia v puede apuntar a cualquier objeto 
		//de la clase que implemente el interfaz volable
		Volable v = new Avion("458841", 495);
		
		Aeropuerto aeropuerto = new Aeropuerto();
		aeropuerto.gestionarVuelo(v);
		
		Pajaro p = new Pajaro();
		aeropuerto.gestionarVuelo(p);
	}
}
