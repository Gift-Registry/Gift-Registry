package com.gift.registry.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String product_id;
    private String productName;
    private int quantity;
    private int price;
    private String colour;
   
    @ManyToOne
    private Inventory inventory;
       
    public Product() {
    }
    
    private Product(Builder builder) {
        id = builder.id;
        product_id = builder.product_id;
        productName = builder.productname;
        quantity  = builder.quantity;
        price = builder.price;
        colour = builder.colour;
        inventory = builder.inventory;
    }

    public static class Builder {
        private Long id;
        private String product_id;
        private String productname;
        private int quantity;
        private int price;
        private String colour;
        private Inventory inventory;
    
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder product_id(String value) {
            this.product_id = value;
            return this;
        }
        
        public Builder productname(String value) {
            this.productname = value;
            return this;
        }
        
        public Builder quantity(int value) {
            this.quantity = value;
            return this;
        }
        
        public Builder price(int value) {
            this.price = value;
            return this;
        }
        
        public Builder colour(String value) {
            this.colour = value;
            return this;
        }
        
        public Builder inventory(Inventory value) {
            this.inventory = value;
            return this;
        }

        public Builder Product(Product product){
            this.id = product.getId();
            this.product_id = product.getProduct_id();
            this.productname = product.getProductname();
            this.quantity = product.getQuantity();
            this.price = product.getPrice();
            this.colour = product.getColour();
            this.inventory = product.getInventory();
            
            return this;   
        }
        
        public Product build(){
            return new Product(this);
        }
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProductname() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }

    public Inventory getInventory() {
        return inventory;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gift.registry.domain.Product[ id=" + id + " ]";
    }
    
}