package com.ecommerce.demo.service;

import com.ecommerce.demo.entity.Product;
import com.ecommerce.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public void addNewProduct(String name, Double price){
        Product newProduct = new Product();
        newProduct.setProduct_name(name);
        newProduct.setProduct_price(price);
        repo.save(newProduct);
    }

    public List<Product> getProductsByName(String name){
        return repo.findProductsByName(name);
    }
}
