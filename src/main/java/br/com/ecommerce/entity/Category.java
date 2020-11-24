package br.com.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categories_id;
    private String categories_title;

    public Integer getCategories_id() {
        return categories_id;
    }

    public String getCategories_title() {
        return categories_title;
    }

    public void setCategories_title(String categories_title) {
        this.categories_title = categories_title;
    }
}
