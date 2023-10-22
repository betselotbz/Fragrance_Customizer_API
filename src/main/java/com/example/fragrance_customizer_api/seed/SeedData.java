package com.example.fragrance_customizer_api.seed;

import com.example.fragrance_customizer_api.model.*;
import com.example.fragrance_customizer_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;


    @Autowired
    public SeedData(@Lazy PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("bethel");
        user.setEmailAddress("bethel@ga.com");
        user.setPassword(passwordEncoder.encode("bethel123"));
        userRepository.save(user);

    }


}

