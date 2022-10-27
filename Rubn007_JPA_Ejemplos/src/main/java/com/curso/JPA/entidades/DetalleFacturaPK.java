package com.curso.JPA.entidades;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
//para una clase que tine dos columnas como PK

@Embeddable
public class DetalleFacturaPK {
	private int idFactura;
	private int lineaDetalle;
}

@Entity
class DetalleFactura{
	@EmbeddedId
	private DetalleFacturaPK id;
	
}