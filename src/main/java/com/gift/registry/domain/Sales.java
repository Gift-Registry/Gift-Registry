package com.gift.registry.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int salesNumber;
    private int amntSold;
    private int total;
       
    public Sales() {
        
    }
    
    private Sales(Builder builder) {
        id = builder.id;
        salesNumber = builder.salesNumber;
        amntSold = builder.amntSold;
        total = builder.total;
    }

    public static class Builder {
        private Long id;
        private int salesNumber;
        private int amntSold;
        private int total;

       public Builder id(Long value) {
           this.id = value;
           return this;
       }

       public Builder salesNumber(int value) {
           this.salesNumber = value;
           return this;
       }
       
        public Builder amntSold(int value) {
           this.amntSold = value;
           return this;
       }
        
        public Builder total(int value) {
           this.total = value;
           return this;
       }
       
       public Builder sales(Sales sales){
           id = sales.getId();
           salesNumber = sales.getAmntSold();
           amntSold = sales.getAmntSold();
           total = sales.getTotal();
           
           return this;   
       }
        
        public Sales build(){
            return new Sales(this);
        }
    }

    public int getSalesNumber() {
        return salesNumber;
    }

    public int getAmntSold() {
        return amntSold;
    }

    public int getTotal() {
        return total;
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
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gift.registry.domain.Sales[ id=" + id + " ]";
    }
    
}
