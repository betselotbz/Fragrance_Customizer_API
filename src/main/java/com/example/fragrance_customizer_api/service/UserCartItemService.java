package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.repository.UserCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCartItemService {
    private UserCartItemRepository userCartItemRepository;

    @Autowired
    public void UserCartItemRepository(UserCartItemRepository userCartItemRepository) {this.userCartItemRepository = userCartItemRepository;}

}
