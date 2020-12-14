package br.com.ecommerce.controller;

import br.com.ecommerce.entity.Product;
import br.com.ecommerce.entity.User;
import br.com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //Search bar
    //If String inserted on search input is of size 4 or more will return a list of matches
    @GetMapping(path = "/getProductsByNameAjax")
    public ResponseEntity<List<Product>> getProductsByNameAjax(@RequestParam String name){
        if(name.length() > 3) {
            try {
                return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping(path = "/getProductsList")
    public ResponseEntity<List<Product>> getProductsList(@RequestParam String name){
        try {
            return new ResponseEntity<>(productService.getProductsByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getProductsByCategoryId")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@RequestParam Integer categoryId){
        try {
            return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/getProductsById")
    public ResponseEntity<Product> getProductsById(@RequestParam Integer productId){
        try {
            return new ResponseEntity<>(productService.getProductsById(productId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/addProduct")
    public ResponseEntity<HttpEntity> addProduct(@RequestParam String name, @RequestParam Double price, @RequestParam Integer category){
        try {
            productService.addNewProduct(name, price, category);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/addClickedProduct")
    public ResponseEntity<HttpEntity> addClickedProduct(@RequestParam Integer productId, HttpSession session){
        try {
            session.setAttribute("clickedProduct", productId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get session
    @GetMapping(path = "getProductSession")
    public ResponseEntity<String> getProductSession (HttpSession session){
        try{
            String clickedProduct = session.getAttribute("clickedProduct").toString();
            session.removeAttribute("clickedProduct");

            return new ResponseEntity<>(clickedProduct, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
