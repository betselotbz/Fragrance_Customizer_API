package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCartItemRepository extends JpaRepository<UserCartItem, Long> {
    List<UserCartItem> findByUser(User user);
    Optional<UserCartItem> findByIdAndUser(Long itemId, User user);
    Optional<UserCartItem>  findById(Long id, User user);

}
