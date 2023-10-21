package com.example.fragrance_customizer_api.security;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//To find the user and get the permissions about user (if user exists, permissions level of permissions that user have)
@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {

        //finding user by emailAddress and wrapping the information with MyUserDetails
        //TO know what user is capable of doing, and what are the things that they don't have access to (we use MyUserDetails info).
        User user = userService.findUserByEmailAddress(emailAddress);
        return new MyUserDetails(user);
    }
}
