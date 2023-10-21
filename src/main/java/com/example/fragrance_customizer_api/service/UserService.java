package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.exception.InformationExistException;
import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;



public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
