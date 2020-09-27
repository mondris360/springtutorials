package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResources {
    // GENERAL API
    @GetMapping("/")
    public String showHomePage(){
        return ("<h1> Welcome To Home Page </h1>");
    }

    @GetMapping("/about")
    public String showAboutPage(){
        return ("<h1> Welcome To About Page</h1>");
    }

    // Accessible by Authenticated users with user or admin role only
    @GetMapping("/user")
    public String showUserPage(){
        return ("<h1> Welcome To User DashBoard/h1>");
    }

    //Accessible by  Authenticated users with admin role only
    @GetMapping("/admin")
    public String showAdminPage(){
        return ("<h1> Welcome ToAdmin  DashBoard/h1>");
    }


}
