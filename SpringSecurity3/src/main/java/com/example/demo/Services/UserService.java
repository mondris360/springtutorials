package com.example.demo.Services;

import com.example.demo.Models.UserPrincipal;
import com.example.demo.Models.User;
import com.example.demo.Respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserService  implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        // if username is not found
        if (user == null){
            throw new UsernameNotFoundException("Invalid Username");
        }

        return new UserPrincipal(user);
    }
}
