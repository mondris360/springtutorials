package com.facebook2.com.service;

import com.facebook2.com.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService  {

    List<Post> getUserPosts(long userID);
    Post createPost(Post newPost);
//    Post getAPostById(long postID);
//    void updatePost(long postID, String updatedMessage);
}
