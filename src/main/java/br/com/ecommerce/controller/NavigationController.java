package br.com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigationController {

    @GetMapping("")
    public String index(){
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

    @GetMapping("cart")
    public String cart(){
        return "cart";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("signin")
    public String signin(){
        return "signin";
    }
}
