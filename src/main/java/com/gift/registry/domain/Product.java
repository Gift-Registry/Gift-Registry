package com.gift.registry.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
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
    
    private int product_id;
   
    @ManyToOne
    private Registry registry;
    
    @Embedded
    private ProductDetails productDetails;
    
    public Product() {
    }
    
    private Product(Builder builder) {
        id = builder.id;
        product_id = builder.product_id;
        registry = builder.registry;
        productDetails = builder.productDetails;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public static class Builder {
        private Long id;
        private int product_id;
        private Registry registry;
        private ProductDetails productDetails;
    
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder product_id(int value) {
            this.product_id = value;
            return this;
        }

        public Builder registry(Registry value) {
            this.registry = value;
            return this;
        }
        
        public Builder productDetails(ProductDetails value) {
            this.productDetails = value;
            return this;
        }

        public Builder Product(Product product){
            id = product.getId();
            product_id = product.getProduct_id();
            registry = product.getRegistry();
            productDetails = product.getProductDetails();

            return this;   
        }
        
        public Product build(){
            return new Product(this);
        }
    }

    public int getProduct_id() {
        return product_id;
    }

    public Registry getRegistry() {
        return registry;
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