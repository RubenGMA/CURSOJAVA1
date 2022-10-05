package com.curso.pruebas;
import com.curso.varios.Saludador;
import java.util.*; /*va a cargar segun se encuentre las 
*clases, por lo que el import no importa nada hasta que no se lo encuentre.
*/
import java.util.Date; //mejor especificar para saber que se está usando.

public class PruebaSaludador {

	public static void main(String[] args) {
		// Uso de la clase Saludador
		
		int numeroCamiones = 2; //Variable de tipo primitivo
		Date fecha = new Date();
		
		//1. Se puede crear un objeto Saludador
		// crear un objeto de la clase, instanciar un objeto de la clase
		
		
		// s1 es una variable de referencia que apunta a objetos de tipo Saludador.
		// com.curso.varios.Saludador s1; //importar de una forma.
		Saludador s1 = new Saludador();
		
		//2. Pedir saludar pasando nombre -> muestra "hola" + nombre
		
		System.out.println(s1.saluda("Begoña Olea")); //syso y control + espacio
		
		//3. Pedir saludar sin nombre -> muestra "Hola Amigo"
		System.out.println(s1.saluda());
		
		//4. Crear un saludador en el que indique el saludo
		Saludador s2 = new Saludador("Buenos días");
		
		//5. Pedir saludo sin nombre "Buenos dias Amigo"
		System.out.println(s2.saluda());
		
	}

}
