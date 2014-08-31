package com.gift.registry.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Registry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int product_id;
    private int occasion_id;
    private int quantity;
    
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name = "invoice_number")
    private List<Invoice> invoices;

    public Registry() {
    }
    
     private Registry(Builder builder) {
        id= builder.id;
        product_id = builder.product_id;
        occasion_id = builder.occasion_id;
        quantity = builder.quantity;
        invoices = builder.invoices;
       }

    public static class Builder {
        private Long id;
        private int product_id;
        private int occasion_id;
        private int quantity;
        private List<Invoice> invoices;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder product_id(int value) {
            this.product_id = value;
            return this;
        }

        public Builder occasion_id(int value) {
            this.occasion_id = value;
            return this;
        }

        public Builder quantity(int value) {
            this.quantity = value;
            return this;
        }
        
        public Builder invoice(List<Invoice> value) {
            this.invoices = value;
            return this;
        }

        public Builder registry(Registry registry){
            this.id = registry.getId();
            this.product_id = registry.getProduct_id();
            this.occasion_id = registry.getOccasion_id();
            this.quantity = registry.getQuantity();
            this.invoices = registry.getInvoices();
            
            return this;   
        }
        
        public Registry build(){
            return new Registry(this);
        }
    }

    public Long getId() {
        return id;
    }    
    
    public int getProduct_id() {
        return product_id;
    }

    public int getOccasion_id() {
        return occasion_id;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public List<Invoice> getInvoices() {
            return invoices;
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
        if (!(object instanceof Registry)) {
            return false;
        }
        Registry other = (Registry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gift.registry.domain.Registry[ id=" + id + " ]";
    }
    
}
