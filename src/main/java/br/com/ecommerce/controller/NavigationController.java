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
}
