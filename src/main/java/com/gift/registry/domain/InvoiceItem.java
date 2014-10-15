package com.gift.registry.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InvoiceItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int quantity;
   
    public InvoiceItem() {
    }
    
     private InvoiceItem(Builder builder) {
        id = builder.id;
        quantity = builder.quantity;
    }

    public static class Builder {
        private Long id;
        private int quantity;
        private List<Product> products;
    
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder quantity(int value) {
            this.quantity = value;
            return this;
        }
       
        public Builder InvoiceItem(InvoiceItem invoiceItem){
            this.id = invoiceItem.getId();
            this.quantity = invoiceItem.getQuantity();
            
            return this;   
        }
        
        public InvoiceItem build(){
            return new InvoiceItem(this);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof InvoiceItem)) {
            return false;
        }
        InvoiceItem other = (InvoiceItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gift.registry.domain.InvoiceItem[ id=" + id + " ]";
    }
    
}
