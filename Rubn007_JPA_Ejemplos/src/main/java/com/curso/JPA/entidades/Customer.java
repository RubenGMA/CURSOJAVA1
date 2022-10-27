package com.curso.JPA.entidades;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MICURSO_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "MICURSO_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    
    @OneToOne
    @JoinColumn(name="CUSTRECORD_RECID")
    private Record record;
    
    @OneToMany(mappedBy = "customer")
    private Collection<Order> pedidos;
    

    public Customer() {}

    public Customer(Integer id) {
        this.id = id;
    }

    public Collection<Order> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Order> pedidos) {
		this.pedidos = pedidos;
	}

	public Customer(Integer id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Customer(Integer id, String customerName, Record record) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.record = record;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //    public Record getCustRecord() {
    //        return custRecord;
    //    }
    //
    //    public void setCustRecord(Record custRecord) {
    //        this.custRecord = custRecord;
    //    }
    //    
    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.programia.demos.entidades.Customer[ id=" + id + " ]";
    }
    
}
