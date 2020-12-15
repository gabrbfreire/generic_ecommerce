package br.com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "products")
public class Product {
//TODO: Add product description and photo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String product_name;
    private Double product_price;
    private Integer categories_id;
    private String product_image_link;

    public Integer getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Integer getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(Integer categories_id) {
        this.categories_id = categories_id;
    }

    public String getProduct_image_link() {
        return product_image_link;
    }

    public void setProduct_image_link(String product_image_link) {
        this.product_image_link = product_image_link;
    }
}
