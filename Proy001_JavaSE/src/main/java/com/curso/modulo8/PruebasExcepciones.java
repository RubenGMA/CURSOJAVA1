package com.curso.modulo8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PruebasExcepciones {
	public static void main(String[] args) {
		
		int resultado = doble("dos");
		System.out.printf("el doble de %d es %d %n", 2, resultado);
		
	}
	
	public static int doble(String numero) {
		//TODO validar que el numero es valido
		//la clase wrapper Integer con metodo parseInt que 
		//convierte un String en int, si no lanza excepción
		int numeroInicial = 0;
		try {
			numeroInicial = Integer.parseInt(numero);
			numeroInicial *= 2;
		}catch(NumberFormatException e) { //primero los catch para capturar la excepcion que conocemos 
			System.out.printf("No se puede calcular doble %nMensaje de error: " + e.getMessage() + "%n");
			
		}catch(Exception e) { //para capturar el resto de excepciones
			System.out.println("Error desconocido");
		}
		return numeroInicial;
	}
	
	public static void guardarResultado(String nombreFichero, int resultado) {
		//import java.io*
		File f = new File(nombreFichero);
		File f2 = new File("parametros.txt");
		try {
			f.createNewFile(); //la ayuda me dice que lanza un IOException
			FileReader fr = new FileReader(f2); //me dice que lanza un FileNotFoundException
		} catch (FileNotFoundException e) {
			System.out.println("el fichero " +  f2 + " no existe");
		} catch (IOException e) {
			System.out.println("No puedo crear el fichero de salida");
		} catch (Exception e) {
			System.out.println("Error desconocido: "+ e.getMessage());
		} finally {
			System.out.println("....siempre me ejecuto");
		}
		
		System.out.println("despues del try catch");
	}
}
