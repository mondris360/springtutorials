package com.facebook2.com.controllers;

import com.facebook2.com.entities.Post;
import com.facebook2.com.serviceImpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class PostController {
   @Autowired
    PostServiceImpl postServiceImpl;

    @PostMapping("/createPost")
    // method to create a new post
    public String createNewPost(Post newPost, Model model, HttpServletRequest request){
        // create a session object
        HttpSession session = request.getSession();
        long userID = (long) session.getAttribute("userID");
        String message =  newPost.getMessage();
        // create a new post object
        Post post =  new Post(userID, message);
//         save the new post to the db
        postServiceImpl.createPost(post);
        return "redirect:/dashboard";

    }
//
//    @GetMapping("/delete")
//    // method to delete a post
//    public String deletePost(@RequestParam long postID, Model model){
//        long id =  postID;
//        postServiceImpl.deletePost(id);
//        return "redirect:/dashboard";
//    }
//
//
//    // method to render the edit post page
//    @GetMapping("/edit")
//    public String showEditPost(@RequestParam long postID,  Model model){
//         // get the post from the database
//        Post post =  postServiceImpl.getAPostById(postID);
//        model.addAttribute("post", post);
//        return "editposts";
//
//    }
//
//
//
//    @PostMapping("/edit")
//    //method to update a post
//    public String editPost(Post editedPost, @Valid BindingResult result){
//        long postID =  editedPost.getPostID();
//        String editedMessage =  editedPost.getMessage();
//        //   update the post
//         postServiceImpl.updatePost(postID, editedMessage);
//
//        return "redirect:/dashboard";
//    }
//
//    // method to like or unlike a post
////    @GetMapping("/like")
////    public String likeOrUnlikePost(@RequestParam long postID, Model model){
////        System.out.println("Id of post to like" + postID );
////
////    }

}
