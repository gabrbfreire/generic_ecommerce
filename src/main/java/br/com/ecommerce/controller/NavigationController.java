package br.com.ecommerce.controller;

import br.com.ecommerce.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class NavigationController {

    @GetMapping("")
    public String index(HttpSession session){
        return "main";
    }

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("product")
    public String product(){
        return "product";
    }

    @GetMapping("search")
    public String search(){
        return "search";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("signin")
    public String signin(){
        return "signin";
    }

    @GetMapping("cart")
    public String boards(HttpSession session) {
        if(session.getAttribute("user")==null){
            return "login";
        }else{
            return "cart";
        }
    }
}
