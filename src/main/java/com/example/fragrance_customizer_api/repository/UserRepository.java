package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAddress(String emailAddress);
}
