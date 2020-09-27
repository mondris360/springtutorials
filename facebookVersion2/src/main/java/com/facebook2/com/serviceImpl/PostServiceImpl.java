package com.facebook2.com.serviceImpl;

import com.facebook2.com.entities.Post;
import com.facebook2.com.repository.PostRepository;
import com.facebook2.com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostServiceImpl  implements PostService {

    @Autowired
    PostRepository postRepository;

//    @Override
//    // method to get all the user posts
//    public List<Post> getUserPosts(long userID) {
//        return postRepository.findAllByUserID(userID);
//    }

    @Override
    // method to create a new post
    public Post createPost(Post newPost) {
        System.out.println("Inside post Service Implementation"+  newPost);
        return postRepository.save(newPost);
    }
//
//    @Override
//    public Post getAPostById(long postID) {
//        return postRepository.findByPostID(postID);
//    }
//
//    @Override
//    public void updatePost(long postID, String updatedMessage) {
//        // get the post record from the db
//        Post post =  postRepository.findByPostID(postID);
//        // update the old post with the new  post  content
//        post.setMessage(updatedMessage);
//        // save the updatef post
//        postRepository.save(post);
//    }


    // method to delete a post
    public void deletePost(Long postID){
        postRepository.deleteById(postID);
    }

    @Override
    public List<Post> getUserPosts(long userID) {
        return null;
    }
}
