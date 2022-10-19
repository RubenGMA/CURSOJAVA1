package com.curso.db;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import com.curso.mercado.entidades.Producto;

public class BaseDatosMercado {
	
	public static Map<Integer, Producto> getTablaProducto() {
		return tablaProducto;
	}
	public static void setTablaProducto(Map<Integer, Producto> tablaProducto) {
		BaseDatosMercado.tablaProducto = tablaProducto;
	}
	public static int getContador() {
		return contador;
	}
	public static void setContador(int contador) {
		BaseDatosMercado.contador = contador;
	}
	private static Map<Integer, Producto> tablaProducto;
	private static int contador = 0;
	
	static {
		tablaProducto = new TreeMap<Integer, Producto>();
		tablaProducto.put(contador, new Producto(contador,"Libro Recetas",30.0));contador++;
		tablaProducto.put(contador, new Producto(contador,"Jarrón chino",340.0));contador++;
		tablaProducto.put(contador, new Producto(contador,"Lapiz",3.0));contador++;
		tablaProducto.put(contador, new Producto(contador,"Cuaderno",15.0));contador++;
	}
	
	private BaseDatosMercado() {
		
	}
	//iniciar el static tablaProducto
	//crear los métodos para añadir, borrar, modidicar, solicitar por id y solicitar datos
	public static void add(String nombre, double precio){
		int newId = ++contador;
		Producto newP = new Producto(newId, nombre, precio);
		tablaProducto.put(newId, newP);
	}
	
	public static Collection<Producto> getAll(){
		return tablaProducto.values();
	}
	public static Producto findById(int id) {
		return tablaProducto.get(id);
	}
	public static void update(Producto pModf) throws Exception{
		Producto p = findById(pModf.getIdProducto());
		if(p == null) {
			throw new Exception("Producto no encontrado para ser modificado");
		}
		tablaProducto.put(pModf.getIdProducto(), pModf);
	}
	public static void delete(int id) {
		tablaProducto.remove(id);
	}
	
}
