package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import com.example.fragrance_customizer_api.service.UserCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-cart-items")
public class UserCartItemController {
    private final UserCartItemService userCartItemService;

    @Autowired
    public UserCartItemController(UserCartItemService userCartItemService) {
        this.userCartItemService = userCartItemService;
    }

    private final HashMap<String, Object> response = new HashMap<>();

    @GetMapping("/")
    public ResponseEntity<?> getAllUserCartItems() {
        List<UserCartItem> userCartItemList = userCartItemService.getAllItemsForCurrentUser();
        response.put("data", userCartItemList);
        response.put("message", "Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{itemId)")
    public ResponseEntity<?> getItemById(@PathVariable Long itemId) {
        Optional<UserCartItem> userCartItem = userCartItemService.getItemById(itemId);
        if (userCartItem.isPresent()) {
            response.put("data", userCartItem);
            response.put("message", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("data", null);
            response.put("message", "Not Found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}