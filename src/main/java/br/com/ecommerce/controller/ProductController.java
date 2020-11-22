package br.com.ecommerce.controller;

import br.com.ecommerce.entity.Product;
import br.com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //Search bar
    //If String inserted on search input is of size 4 or more will return a list of matches
    @GetMapping(path = "/product")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name){
        if(name.length() > 3) {
            try {
                return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping(path = "/product")
    public ResponseEntity<HttpEntity> addProduct(@RequestParam String name, @RequestParam Double price){
        try {
            productService.addNewProduct(name, price);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
