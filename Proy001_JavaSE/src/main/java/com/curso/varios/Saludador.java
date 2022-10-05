package com.curso.varios;

/*
 * JVM carga la clase com.curso.varios.Saludador (Full Qualified Name)
 */

// Ejemplo de aplicación de "Saludo"

public class Saludador {
	// Atributos
	private String saludo = "Hola";

	// Constructores
	public Saludador() {
		super();
		this.saludo = "Hola";
	}

	public Saludador(String saludo) {
		this.saludo = saludo; //this es para hacer referencia a un atributo de esta clase.
	}
	// si le ponemos public void al contructor ya no es constructor es un metodo.

	// Metodos
	public String saluda(String nombreUsuario) {
		return this.saludo + nombreUsuario;
	}

	// sobrecargar el metodo si lo declaro igual.
	public String saluda() {
		return this.saludo + " Amigo";
	}

}
