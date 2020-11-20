package br.com.ecommerce.controller;

import br.com.ecommerce.entity.User;
import br.com.ecommerce.service.CartItemService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping(path = "addItemToUserCart")
    public ResponseEntity<HttpStatus> addItemToUserCart(@RequestParam Integer productId, @RequestParam Integer productQuantity, @SessionAttribute User user){
        try {
            cartItemService.addItemToUserCart(productId, productQuantity, user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
