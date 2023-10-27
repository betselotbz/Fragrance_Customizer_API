package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.request.LoginRequest;
import com.example.fragrance_customizer_api.model.response.LoginResponse;
import com.example.fragrance_customizer_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

import static com.example.fragrance_customizer_api.service.UserService.getCurrentLoggedInUser;

@RestController
@RequestMapping("/auth/users")
public class UserController {
    private final UserService userService;
    HashMap<String, Object > response = new HashMap<>();
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        response.put("message","success");
        response.put("data", createdUser);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PostMapping("/login/")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest){
        Optional<String> jwtToken = userService.loginUser(loginRequest);
        if (jwtToken.isPresent()){
            return ResponseEntity.ok(new LoginResponse(jwtToken.get()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Authentication failed"));
    }

    @GetMapping("/currentUser")
    public ResponseEntity<?> getCurrentUser() {
        User currentUser = getCurrentLoggedInUser();
        response.put("message","success");
        response.put("data", currentUser);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}