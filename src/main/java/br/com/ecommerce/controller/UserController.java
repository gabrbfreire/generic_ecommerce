package br.com.ecommerce.controller;

import br.com.ecommerce.entity.User;
import br.com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@SessionAttributes("user")  //Session attributes
public class UserController {

    @Autowired
    private UserService userService;


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
    @PostMapping(path="/signup") // Map ONLY POST Requests
    public ResponseEntity<HttpStatus> addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String password){
        try{
            try {
                userService.addNewUser(name, email, password);
            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if(createSession(email, password)!=null){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //--------------------
    //Get session
    @GetMapping(path = "getSession")
    public ResponseEntity<Integer> getSession (@SessionAttribute("user") User user){
        try{
            return new ResponseEntity<>(user.getUser_id(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
