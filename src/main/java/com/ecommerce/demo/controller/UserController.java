package com.ecommerce.demo.controller;

import com.ecommerce.demo.entity.User;
import com.ecommerce.demo.service.CartService;
import com.ecommerce.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@SessionAttributes("user")  //Session attributes
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

//  -----USER-----
//  Login
//  Get user
    @PostMapping(path="/login")
    public ResponseEntity<HttpStatus> getAllUsers(@RequestParam String email, @RequestParam String password) {
        try{
            if(createSession(email, password)!=null){
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ModelAttribute("user") //Session model
    private User createSession(String email, String password){
        return userService.findUserByEmail(email, password);
    }

    // Sign up
    // Create user
    @PostMapping(path="/signup") // Map ONLY POST Requests
    public ResponseEntity<HttpStatus> addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password){
        try{
            userService.addNewUser(name, email, password);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Create cart
    @PostMapping(path="addCart")
    public ResponseEntity<HttpStatus> addCart(@SessionAttribute("user") User user) {
        try{
            cartService.addNewCart(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
