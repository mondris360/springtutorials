package com.facebook.com.controllers;

import com.facebook.com.model.User;
import com.facebook.com.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    UserServiceImpl userServiceImpl;

    @Autowired
    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String listUsers(User user){
        System.out.println(user);
        user.setAddress("No 4a ICE ROAD, edo");
        user.setFirstName("Mark");
        user.setLastName("James");
        user.setNationality("NIGERIA");
        user.setGender("Male");
        userServiceImpl.saveUserData(user);
        return "index";
    }
}
