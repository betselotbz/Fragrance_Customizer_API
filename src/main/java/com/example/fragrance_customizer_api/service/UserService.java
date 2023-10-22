package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.exception.InformationExistException;
import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.request.LoginRequest;
import com.example.fragrance_customizer_api.repository.UserRepository;
import com.example.fragrance_customizer_api.security.JWTUtils;
import com.example.fragrance_customizer_api.security.MyUserDetails;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final JWTUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private static User loggedinUser;
    private final PasswordEncoder passwordEncoder;

    /**
     * Constructs a new instance of the UserService class with the provided
     * UserRepository dependency. This constructor is used to initialize the
     * service with the necessary repository for performing user-related operations.
     */
    public UserService(UserRepository userRepository, JWTUtils jwtUtils, @Lazy AuthenticationManager authenticationManager, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Retrieves a user by their unique identifier from the UserRepository.
     *
     * @param userId The unique identifier (ID) of the user to retrieve.
     * @return An Optional containing the user if found, or an empty Optional if not found.
     */
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    /**
     * Creates a new user by saving the provided user object to the UserRepository.
     *
     * @param user The user object to be created and saved.
     * @return The new user object with any assigned identifiers.
     */
    public User createUser(User user) {
        // You can add validation logic here if needed
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Updates an existing user's information with the provided data and saves the changes to the UserRepository.
     * This method checks if a user with the given ID exists, and if so, it updates the specified fields (name, email address, and password)
     * with the values from the provided updatedUser object. The updated user is then saved to the repository.
     * If no user with the given ID is found, an IllegalArgumentException is thrown.
     *
     * @param userId      The unique identifier (ID) of the user to update.
     * @param updatedUser The user object containing the updated information.
     * @return The updated user object with the changes saved.
     * @throws IllegalArgumentException if no user with the given ID is found.
     */
    public User updateUser(Long userId, User updatedUser) {
        // Check if the user with the given ID exists
        Optional<User> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            // Update the fields you want to change
            existingUser.setName(updatedUser.getName());
            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle the case where the user with the given ID doesn't exist
            throw new IllegalArgumentException();
        }
    }


    /**
     * Retrieve the currently logged-in user from the security context.
     *
     * @throws ClassCastException If the user details in the security context cannot be cast to MyUserDetails.
     */
    public static void getCurrentLoggedInUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        loggedinUser = userDetails.getUser();
    }

    /**
     * Find a user by their email address.
     *
     * @param emailAddress The email address of the user to be found.
     * @return The user with the provided email address if found, or null if no user matches the given email address.
     */
    public User findUserByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    /**
     * Authenticate a user based on their login credentials provided in the `LoginRequest`.
     *
     * @param loginRequest The `LoginRequest` containing the user's email address and password for authentication.
     * @return An `Optional` containing a JSON Web Token (JWT) if authentication is successful,
     * or an empty `Optional` if authentication fails.
     */
    public Optional<String> loginUser(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            return Optional.of(jwtUtils.generateJwtToken(myUserDetails));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}