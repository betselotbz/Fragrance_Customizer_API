package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import com.example.fragrance_customizer_api.service.UserCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.example.fragrance_customizer_api.service.UserService.getCurrentLoggedInUser;

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

        User currentUser = getCurrentLoggedInUser();
        if (Objects.equals(currentUser.getType(), "admin")){
            List<UserCartItem> userCartItemList = userCartItemService.getAllItems();
            response.put("data", userCartItemList);
            response.put("message", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        List<UserCartItem> userCartItemList = userCartItemService.getAllItemsForCurrentUser();
        response.put("data", userCartItemList);
        response.put("message", "Success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
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


    @PostMapping
    public UserCartItem createItem(@RequestBody UserCartItem item) {
        return userCartItemService.createItem(item);
    }


    // Update
    @PutMapping
    public UserCartItem updateItem(@RequestBody UserCartItem item) {
        return userCartItemService.updateItem(item.getId(), item);
    }



    @DeleteMapping ("/{itemId}")
    public ResponseEntity<?> deleteItemById(@PathVariable Long itemId) {
        UserCartItem deletedItem = userCartItemService.deleteItemById(itemId);
        if (deletedItem != null) { //.isPresent
            response.put("data", deletedItem);
            response.put("message", "Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("data", null);
            response.put("message", "Not Found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

}