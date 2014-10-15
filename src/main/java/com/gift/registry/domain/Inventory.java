package com.gift.registry.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long requestedAmnt;
    private Long purchasedAmnt;
    private Long remainingAmnt;
    
    @ManyToOne
    private Product product;
    
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private List<Customer> customers;
    
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private List<Invoice> invoices;
    
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name = "inventory_id")
    private List<Sales> sales;   
    
    public Inventory() {
    }
    
    private Inventory(Builder builder) {
        id= builder.id;
        requestedAmnt = builder.requestedAmnt;
        purchasedAmnt = builder.purchasedAmnt;
        remainingAmnt = builder.remainingAmnt;
        invoices = builder.invoices;
        customers = builder.customers;
        sales = builder.sales;
       }

    public static class Builder {
        private Long id;
        private Long requestedAmnt;
        private Long purchasedAmnt;
        private Long remainingAmnt;
        private Product product;
        private List<Invoice> invoices;
        private List<Customer> customers;
        private List<Sales> sales;

        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder requestedAmnt(Long value) {
            this.requestedAmnt = value;
            return this;
        }

        public Builder purchasedAmnt(Long value) {
            this.purchasedAmnt = value;
            return this;
        }

        public Builder remainingAmnt(Long value) {
            this.remainingAmnt = value;
            return this;
        }
        
        public Builder product(Product value) {
            this.product = value;
            return this;
        }
        
        public Builder invoices(List<Invoice> value) {
            this.invoices = value;
            return this;
        }
        
       public Builder customers(List<Customer> value) {
            this.customers = value;
            return this;
        }
       
        public Builder sales(List<Sales> value) {
            this.sales = value;
            return this;
        }
       
        public Builder inventory(Inventory inventory){
            this.id = inventory.getId();
            this.requestedAmnt = inventory.getRequestedAmnt();
            this.purchasedAmnt = inventory.getPurchasedAmnt();
            this.remainingAmnt = inventory.getRemainingAmnt();
            this.product = inventory.getProduct();
            this.invoices = inventory.getInvoices();
            this.customers = inventory.getCustomers();
            this.sales = inventory.getSales();
            
            return this;   
        }
        
        public Inventory build(){
            return new Inventory(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Long getRequestedAmnt() {
        return requestedAmnt;
    }

    public Long getPurchasedAmnt() {
        return purchasedAmnt;
    }

    public Long getRemainingAmnt() {
        return remainingAmnt;
    }

    public Product getProduct() {
        return product;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Sales> getSales() {
        return sales;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gift.registry.domain.Inventory[ id=" + id + " ]";
    }
    
}
