package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCartItemRepository extends JpaRepository<UserCartItem, Long> {
    Optional<UserCartItem> findByUserAndId(User user, Long id);

}
