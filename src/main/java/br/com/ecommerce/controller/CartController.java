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
    @PostMapping(path="addCartYesLogin")
    public ResponseEntity<HttpStatus> addCartWithLogin(@SessionAttribute("user") User user) {
        try{
            cartService.addNewCartWithLogin(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Create cart for unregistered user
    @PostMapping(path="addCartNoLogin")
    public ResponseEntity<HttpStatus> addCartNoLogin() {
        try{
            cartService.addNewCartNoLogin();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "getUserCart")
    public ResponseEntity<Cart> getCart(@SessionAttribute("user") User user){
        try {
            System.out.println(user.getUser_id());
            return new ResponseEntity<>(cartService.getCartByUserId(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
