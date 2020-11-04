package com.ecommerce.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "carts_has_products")
public class Carts_has_product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carts_cart_id;
    private Integer products_product_id;

    public Integer getCarts_cart_id() {
        return carts_cart_id;
    }

    public Integer getProducts_product_id() {
        return products_product_id;
    }
}
