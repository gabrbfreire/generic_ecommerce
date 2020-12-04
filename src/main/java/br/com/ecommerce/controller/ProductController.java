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
    @GetMapping(path = "/getProductsByName")
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

    @GetMapping(path = "/getProductsByCategoryId")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@RequestParam Integer categoryId){
        try {
            return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/addProduct")
    public ResponseEntity<HttpEntity> addProduct(@RequestParam String name, @RequestParam Double price, @RequestParam Integer category){
        try {
            productService.addNewProduct(name, price, category);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
