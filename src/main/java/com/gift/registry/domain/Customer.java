package com.gift.registry.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String customer_id;
    
    @ManyToOne
    private Inventory inventory;
    
    @Embedded
    private Details details;
    
    @Embedded
    private Address address;

    public Customer() {
    }
    
    private Customer(Builder builder) {
        id = builder.id;
        customer_id = builder.customer_id;
        inventory = builder.inventory;
        details = builder.details;
        address = builder.address;
    }

    public static class Builder {
        private Long id;
        private String customer_id;
        private Inventory inventory;
        private Details details;
        private Address address;
    
       public Builder id(Long value) {
           this.id = value;
           return this;
       }

       public Builder customer_id(String value) {
           this.customer_id = value;
           return this;
       }
       
        public Builder inventory(Inventory value) {
           this.inventory = value;
           return this;
        }
        
        public Builder details(Details value) {
           this.details = value;
           return this;
        }
        
        public Builder address(Address value) {
           this.address = value;
           return this;
        }

       public Builder customer(Customer customer){
           id = customer.getId();
           customer_id = customer.getCustomer_id();
           inventory = customer.getInventory();
           details = customer.getDetails();
           address = customer.getAddress();
           
           return this;   
       }
        
        public Customer build(){
            return new Customer(this);
        }
    }
    
    public Long getId() {
        return id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Details getDetails() {
        return details;
    }

    public Address getAddress() {
        return address;
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
        return "com.gift.registry.domain.Customer[ id=" + id + " ]";
    }
    
}
