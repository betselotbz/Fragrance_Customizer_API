package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.Ingredient;
import com.example.fragrance_customizer_api.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public List<Ingredient> getAllIngredients() {return ingredientRepository.findAll();}
    public Optional<Ingredient> getIngredientByName(String name) {
        return ingredientRepository.findByName(name);
    }
    public Optional<Ingredient> getIngredientById(Long Id) {
        return ingredientRepository.findById(Id);
    }
}
