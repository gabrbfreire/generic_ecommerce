package br.com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(path="/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "main";
    }
}