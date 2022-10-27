package com.curso.JPA.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "ORDERS")
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Order o")
    , @NamedQuery(name = "Orders.findByOrderid", query = "SELECT o FROM Order o WHERE o.orderid = :orderid")
    , @NamedQuery(name = "Orders.findByDescription", query = "SELECT o FROM Order o WHERE o.descripcion = :descripcion")})
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "ORDER_SEQ", allocationSize=1)
  
    @Column(name = "ORDERID")
    private Integer orderid;
  
    @Column(name = "DESCRIPTION")
    private String descripcion;    
    
//    @Column(name="CUSTOMER_ID")
//    private Integer idCliente;
    
   
    
    @ManyToOne  @JoinColumn(name = "CUSTOMER_ID") //nombre de la columna en tabla orders
//    						, referencedColumnName = "ID")// nombre de la columna en tabla clientes, pero no es necesario indicado
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderid) {
        this.orderid = orderid;
    }

    public Order(Integer orderid, String description) {
        this.orderid = orderid;
        this.descripcion = description;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getDescription() {
        return descripcion;
    }

    public void setDescription(String description) {
        this.descripcion = description;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.programia.demos.entidades.Orders[ orderid=" + orderid + " ]";
    }
    
}
