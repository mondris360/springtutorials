package com.facebook.com.controllers;

import com.facebook.com.model.User;
import com.facebook.com.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    UserServiceImpl userServiceImp;

    // constructor
    @Autowired
    public SignupController(UserServiceImpl  userServiceImpl){
        this.userServiceImp =  userServiceImpl;
    }
    @GetMapping("/signup")
    public String getUsers(){
//        userServiceImp.saveUserData(user);
        return "signUp";
    }

    @PostMapping("/signup")
    public  String addUsers(User user){
        userServiceImp.saveUserData(user);

        return "signup";
    }


}
