package com.curso.colecciones;

import java.util.Objects;

public class Punto implements Comparable<Punto>{
	private int x;
	private int y;
	
	public Punto(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		return "Punto [x=" + x + ", y=" + y + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	} // el hasCode y el equals tienen que comparar los mismos valores.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return x == other.x && y == other.y;
	}
	
	/**
	 * @param o
	 * @return 0 si son iguales >0 si es mayor <0 si es menor
	 */
	@Override
	public int compareTo(Punto o) {
		if (this.x == o.x && this.y == o.y)
			return 0;
		if (this.x == o.x) {
			return this.y - o.y;
		}else {
			return this.x - o.x;
		}
	}
	
	
}
