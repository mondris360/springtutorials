package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {

    @GetMapping("/")
    public String showHomePage(){
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping("/logout")
    public String showLogout(){
        return "logout";
    }
}
