package com.facebook.com.service;

import com.facebook.com.model.User;
import com.facebook.com.repository.UserRepository;

import java.util.List;

public interface UserService {
    public void saveUserData(User data);
    public List<User> retrieveUsers();


}
