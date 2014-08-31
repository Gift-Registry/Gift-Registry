package com.gift.registry.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class ProductDetails implements Serializable {
    private String productname;
    private int quantity;
    private int price;
    private String colour;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}

