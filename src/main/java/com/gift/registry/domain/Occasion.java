package com.gift.registry.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Occasion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String occasionId;
    private String occasionName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date occasionDate;
    
    @OneToMany(orphanRemoval=true,cascade= CascadeType.ALL)
    @JoinColumn(name = "occasion_id")
    private List<Product> products;

    public Occasion() {
    }
    
    private Occasion(Builder builder) {
        id= builder.id;
        occasionId = builder.occasion_id;
        occasionName = builder.occasion_name;
        occasionDate = builder.occasion_date;
        products = builder.products;
    }

    public static class Builder {
        private Long id;
        private String occasion_id;
        private String occasion_name;
        private Date occasion_date;
        private List<Product> products;
    
        public Builder id(Long value) {
            this.id = value;
            return this;
        }

        public Builder occasion_id(String value) {
            occasion_id = value;
            return this;
        }

        public Builder occasion_name(String value) {
            this.occasion_name = value;
            return this;
        }
        
        public Builder occasion_date(Date value) {
            this.occasion_date = value;
            return this;
        }
        
        public Builder products(List<Product> value) {
            this.products = value;
            return this;
        }

        public Builder Occasion(Occasion occasion){
            this.id = occasion.getId();
            this.occasion_id = occasion.getOccasion_id();
            this.occasion_name = occasion.getOccasion_name();
            this.occasion_date = occasion.getOccasion_date();
            this.products = occasion.getProducts();
            
            return this;   
        }
        
        public Occasion build(){
            return new Occasion(this);
        }
    }

    public String getOccasion_id() {
        return occasionId;
    }

    public String getOccasion_name() {
        return occasionName;
    }

    public Date getOccasion_date() {
        return occasionDate;
    }

    public List<Product> getProducts() {
        return products;
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
        if (!(object instanceof Occasion)) {
            return false;
        }
        Occasion other = (Occasion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gift.registry.domain.Occasion[ id=" + id + " ]";
    }
    
}
