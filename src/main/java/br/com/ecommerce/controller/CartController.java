package br.com.ecommerce.controller;

import br.com.ecommerce.entity.Cart;
import br.com.ecommerce.entity.User;
import br.com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {


    @Autowired
    private CartService cartService;

    //  -----CART-----
    //Create cart for registered user
    @PostMapping(path="addCart")
    public ResponseEntity<HttpStatus> addCart(@SessionAttribute("user") User user) {
        try{
            cartService.addNewCart(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "getUserCart")
    public ResponseEntity<Cart> getCart(@SessionAttribute("user") User user){
        try {
            return new ResponseEntity<>(cartService.getCartByUser(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
