package br.com.ecommerce.service;

import br.com.ecommerce.repository.ProductRepository;
import br.com.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public void addNewProduct(String name, Double price, Integer category){
        Product newProduct = new Product();
        newProduct.setProduct_name(name);
        newProduct.setProduct_price(price);
        newProduct.setCategories_id(category);
        repo.save(newProduct);
    }

    public List<Product> getProductsByName(String name){
        return repo.findProductsByName(name);
    }
}
