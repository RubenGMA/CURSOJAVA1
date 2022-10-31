package com.curso.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTO_SEQ")
	 @SequenceGenerator(sequenceName = "PRODUCTO_SEQ", name = "PRODUCTO_SEQ", allocationSize=1)
	    
	@Column(name = "ID_PRODUCTO")
	private Integer idProducto;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "PRECIO")
	private double precio;
	@Column(name = "STOCK")
	private int stock = 5;
	
	
	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public Producto() {
		super();
	}


	public Producto(Integer idProducto, String descripcion, double precio) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}


	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(idProducto, other.idProducto);
	}
}

