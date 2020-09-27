package com.facebook2.com.service;

import com.facebook2.com.entities.Post;
import com.facebook2.com.entities.User;
import org.springframework.stereotype.Service;
import util.Response;

@Service
public interface UserService {

     void saveUser(User user);
     User getUserById(long userID);
     Response login (User user);
     void deleteUser(String userID);

////     List<Post> getUserPosts();

     User findUserByEmail(String email);

}
