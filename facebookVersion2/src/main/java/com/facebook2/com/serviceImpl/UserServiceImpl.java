package com.facebook2.com.serviceImpl;

import com.facebook2.com.entities.User;
import com.facebook2.com.repository.UserRepository;
import com.facebook2.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.Response;

@Component
public class UserServiceImpl  implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    // method to create a new user
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(long userID) {
        return userRepository.findByUserID(userID);
    }


    @Override
    public void deleteUser(String userID) {

    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

//    @Override
//    public void deleteUser(String userID) {
//
//    }
//
//
//    @Override
//    public User getUserById(String userID) {
//        return null;
//    }
//
//    @Override
//    // method to fetch user from the db by email
//    public User findUserByEmail(String email) {
//        return userRepository.findUserByEmail(email);
//    }
//
//    @Override
//    // method to check if user login details  are correct.
    public Response login(User user) {
        System.out.println("inside servIMP");
        User getUser =  findUserByEmail(user.getEmail());
        System.out.println("result for by email" + getUser);
        System.out.println("email paseed in" + user.getEmail());

        // if no record was found
        if (getUser ==  null){
            return new Response(false, 202, "Invalid User Email Address");
            // if a record was found, verify the password
        } else if (!user.getPassword().equals(getUser.getPassword())) {

            return  new Response(false, 202,"Invalid Password");
            // if the password is valid
        } else {
            return new Response(true, 200, "Valid Login", getUser);
        }
    }


}
