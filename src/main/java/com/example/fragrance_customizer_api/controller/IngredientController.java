package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.Ingredient;
import com.example.fragrance_customizer_api.model.Perfume;
import com.example.fragrance_customizer_api.service.IngredientService;
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
@RequestMapping("/api/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllIngredients() {
        List<Ingredient> ingredientList = ingredientService.getAllIngredients();
        HashMap<String, Object> message = new HashMap<>();

        if (ingredientList.isEmpty()) {
            message.put("message", "Cannot find any perfumes.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", ingredientList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIngredientById(@PathVariable Long id) {
        Optional<Ingredient> optionalIngredient = ingredientService.getIngredientById(id);
        HashMap<String, Object> message = new HashMap<>();
        if (optionalIngredient.isPresent()) {
            Ingredient ingredient = optionalIngredient.get();
            message.put("message", "Success");
            message.put("data", ingredient);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Cannot find any Ingredient with the given ID.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getIngredientByName(@PathVariable String name) {
            Optional<Ingredient> optionalIngredient = ingredientService.getIngredientByName(name);
            HashMap<String, Object> message = new HashMap<>();
            if (optionalIngredient.isPresent()) {
                Ingredient ingredient = optionalIngredient.get();
                message.put("message", "Success");
                message.put("data", ingredient);
                return new ResponseEntity<>(message, HttpStatus.OK);
            } else {
                message.put("message", "Cannot find any Ingredient with the given name.");
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }
        }

}
