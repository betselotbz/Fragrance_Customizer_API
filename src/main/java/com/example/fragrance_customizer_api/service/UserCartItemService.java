package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.exception.InformationNotFoundException;
import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import com.example.fragrance_customizer_api.repository.UserCartItemRepository;
import com.example.fragrance_customizer_api.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    //To get all items in User Cart
    public List<UserCartItem> getAllItemsForCurrentUser() {
        User currentUser = getCurrentLoggedInUser();
        return userCartItemRepository.findByUser(currentUser);
    }
    //To get a specific item in User Cart
    public Optional<UserCartItem> getItemById(Long itemId){
        Optional<UserCartItem> optionalUserCartItem = userCartItemRepository.findById(itemId);
        if(optionalUserCartItem.isPresent()) {
            return optionalUserCartItem;
        }
        throw new InformationNotFoundException("UserCartItem with Id " + itemId+ " not found");
    }
    public UserCartItem deleteItem(Long itemId) {
        User currentUser = getCurrentLoggedInUser();
        Optional<UserCartItem> optionalUserCartItem = userCartItemRepository.findByIdAndUser(itemId, currentUser);
        if (optionalUserCartItem.isPresent()) {
            UserCartItem userCartItem = optionalUserCartItem.get();
            userCartItemRepository.delete(userCartItem);
            return userCartItem;
        } else {
            throw new InformationNotFoundException("You don't have an item with Id " + itemId);
        }
    }

}

