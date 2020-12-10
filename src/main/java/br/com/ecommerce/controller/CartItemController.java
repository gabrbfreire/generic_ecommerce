package br.com.ecommerce.controller;

import br.com.ecommerce.entity.CartItem;
import br.com.ecommerce.entity.User;
import br.com.ecommerce.service.CartItemService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {

    @Autowired
    CartItemService cartItemService;

    @PostMapping(path = "addItemUserCart")
    public ResponseEntity<HttpStatus> addItemUserCart(@RequestParam Integer productId, @SessionAttribute User user){
        try {
            cartItemService.addItemUserCart(productId, user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "getItemsUserCart")
    public ResponseEntity<List<CartItem>> getItemsUserCart(@SessionAttribute User user){
        try {
            return new ResponseEntity<>(cartItemService.getItemsUserCart(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "removeItemUserCart")
    public ResponseEntity<HttpStatus> removeItemUserCart(@RequestParam Integer cartItemId){
        try {
            cartItemService.removeItemUserCart(cartItemId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "removeAllItemsUserCart")
    public ResponseEntity<HttpStatus> removeAllItemsUserCart(@SessionAttribute User user){
        try {
            cartItemService.removeAllItemsUserCart(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "updateItemQuantityUserCart")
    public ResponseEntity<HttpStatus> updateItemQuantityUserCart(@RequestParam Integer cartItemId, @RequestParam Integer productQuantity){
        try {
            cartItemService.updateItemQuantityUserCart(cartItemId, productQuantity);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
