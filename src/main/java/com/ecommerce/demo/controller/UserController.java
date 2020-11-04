package com.ecommerce.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    // -----USER-----
    // Login
    // Get user
//    @PostMapping(path = "/login")
//    public ResponseEntity<HttpStatus> getAllUsers(@RequestParam String userName, @RequestParam String password) {
//        try{
//            if(createSession(userName, password)!=null){
//                return new ResponseEntity<>(HttpStatus.OK);
//            }else{
//                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @ModelAttribute("user") //Session model
//    private User createSession(String email, String password){
//
//        return userService.findUserByEmail(email, password);
//    }
//
//    // Sign up
//    // Create user
//    @PostMapping(path="/signup") // Map ONLY POST Requests
//    public ResponseEntity<HttpStatus> addUser (@RequestParam String email, @RequestParam String password){
//        try{
//            userService.addNewUser(email, password);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
