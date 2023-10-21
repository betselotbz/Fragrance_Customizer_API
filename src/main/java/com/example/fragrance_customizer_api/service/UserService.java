package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.exception.InformationExistException;
import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.repository.UserRepository;
import com.example.fragrance_customizer_api.security.JWTUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;



public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder, JWTUtils jwtUtils,
                       @Lazy AuthenticationManager authenticationManager, AuthenticationManager authenticationManager1){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager1;
    }
    public User createUser(User userObject) {
        if (userObject == null) {
            throw new IllegalArgumentException("User object cannot be null.");
        }
        // Check if a user with the same email address already exists
        if (!userRepository.existsByEmailAddress(userObject.getEmailAddress())) {
            // Encode the user's password for security
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            // Save the user to the database
            return userRepository.save(userObject);
        } else {
            // Throw an exception if the email address is already in use
            throw new InformationExistException("User with email address " + userObject.getEmailAddress() + " already exists");
        }
    }
    public User findUserByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }


}
