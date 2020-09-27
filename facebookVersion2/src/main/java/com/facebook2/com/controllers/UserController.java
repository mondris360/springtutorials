package com.facebook2.com.controllers;


import com.facebook2.com.entities.Post;
import com.facebook2.com.entities.User;
import com.facebook2.com.service.PostService;
import com.facebook2.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import util.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userServiceImpl;
    @Autowired
    PostService postService;



    // routes
    @GetMapping("/index")
    public String showIndexPage(Model model){
        model.addAttribute("user", new User());
//        model.addAttribute("response", new Response(false, 404, "invalid"));
        return "index";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, Model model) {
//        if (result.hasErrors()) {
//            return "sign-up";
//        }
        String email =  user.getEmail();
        String password =  user.getPassword();
        System.out.println(user);
        userServiceImpl.saveUser(user);
        return "redirect:/index";
    }

    // login route
    @PostMapping("/login")
    // method to authenticate the user login details
    public String login(User user, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model){
        HttpSession session =  request.getSession();
        // authenticate the user;
        Response response =  userServiceImpl.login(user);
        User userRecord = (User) response.getData();
         if (response.isSuccessful()) {
             // store the session
             session.setAttribute("userID", userRecord.getUserID());
//             List<Post> getUsersPost =  postService.getUserPosts(userRecord.getUserID());
//             System.out.println("User Posts===============================");
//             System.out.println(getUsersPost);

             System.out.println("valid login");
            return "redirect:/dashboard";

         } else {
             System.out.println(response.getData());
             System.out.println("invalid login");
             // get all the user posts from the db
             redirectAttributes.addFlashAttribute("error", response.getMessage());
             // set the http status code
             return "redirect:/index";
         }

    }

    // method to display the dashboard
    @GetMapping("/dashboard")
    public String dashboard(User user, RedirectAttributes redirectAttributes, Model model) {
//        List<Post> getUserPosts =  postService.getUserPosts(10);
        List<Post> getUserPosts = new ArrayList<>();

        model.addAttribute("post", new Post());
        model.addAttribute("posts", getUserPosts);
        return "posts";
    }

}
