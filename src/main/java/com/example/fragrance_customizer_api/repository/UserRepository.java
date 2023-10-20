package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailAddress(String emailAddress);  //implemented by JPA

    // Query method to check if a user with a given email address exists.
    boolean existsByEmailAddress(String userEmailAddress);
}
