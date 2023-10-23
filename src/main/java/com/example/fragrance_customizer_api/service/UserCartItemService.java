package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import com.example.fragrance_customizer_api.repository.UserCartItemRepository;
import com.example.fragrance_customizer_api.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCartItemService {

    private final UserCartItemRepository userCartItemRepository;

    @Autowired
    public UserCartItemService(UserCartItemRepository userCartItemRepository) {
        this.userCartItemRepository = userCartItemRepository;
    }
    public User getCurrentLoggedInUser(){

        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return myUserDetails.getUser();

    }
    public List<UserCartItem> getAllItems() {
        return userCartItemRepository.findAll();
    }

}
