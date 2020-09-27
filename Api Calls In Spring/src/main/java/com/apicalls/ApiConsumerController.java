package com.apicalls;


import com.apicalls.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/consumingapi")
public class ApiConsumerController {
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody  List<Object> getResourcesFromApi(){
        String apiEndPoint = "https://jsonplaceholder.typicode.com/photos";
        Object[] apiResponse =  restTemplate.getForObject(apiEndPoint, Object[].class);
        // convert the  response to a list of objects
        List<Object> responseAsListOfObject = Arrays.asList(apiResponse);
        System.out.println(responseAsListOfObject);
        return responseAsListOfObject;
    }


    @GetMapping("/getpostbyid")
    public @ResponseBody List<Object> getUserByID(){
        String ApiEndPoint = "https://jsonplaceholder.typicode.com/comments?postId={id}";
        // create  params for request
        Map<String, Integer> params =  new HashMap<>();
        params.put("id",5);

        ResponseEntity<Object[]> response =  restTemplate.getForEntity(ApiEndPoint, Object[].class, params);
        List<Object> user =  Arrays.asList(response);
        System.out.println("++++++++++++++++++" + user);
        return  user;
    }


    // api call to create  a new post
    @PostMapping("/createpost")
    public void createUser(){
        String endPoint =  	"https://jsonplaceholder.typicode.com/posts";
        Post post =  new Post(5,3,"Mondris", "Mondris is a fine boy");
        ResponseEntity<Post> createPost =  restTemplate.postForEntity(endPoint, post, Post.class);
        System.out.println(createPost.getBody());
    }
}
