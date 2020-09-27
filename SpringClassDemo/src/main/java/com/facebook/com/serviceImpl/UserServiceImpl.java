package com.facebook.com.serviceImpl;

import com.facebook.com.model.User;
import com.facebook.com.repository.UserRepository;
import com.facebook.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUserData(User data) {
            userRepository.save(data);
    }

    @Override
    public List<User> retrieveUsers() {
        return null;
    }
}
