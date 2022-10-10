package com.curso.modulo7;

public class Cliente {
	private static final double DESCUENTO_MAX = 30.0;
	private String nombre;
	
	public void verDatos(){
		System.out.println("... lode satos del cliente");
	}
	public final void hazAlgo() {
		System.out.println("trabajando...");
	}
}

final class ClienteVIP extends Cliente{
	@Override
	public void verDatos() {
		super.verDatos();
	}
	
	//no se puede
	@Override
	public void hazAlgo() {
		super.hazAlgo();
	}
}

//no se pued ehacer herencia de una clase final
class ClienteExtrVip extends ClienteVIP{
}
