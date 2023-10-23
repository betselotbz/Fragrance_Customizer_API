package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.Ingredient;
import com.example.fragrance_customizer_api.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {

    private final List<Ingredient> ingredientList;

    private IngredientRepository ingredientRepository;

    @Autowired
    public void setIngredientRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public IngredientService(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
    public List<Ingredient> getAllIngredients() {return ingredientRepository.findAll();}
    public Optional<Ingredient> getIngredientByName(String name) {
        return ingredientRepository.findByName(name);
    }
    public Optional<Ingredient> getIngredientById(Long Id) {
        return ingredientRepository.findById(Id);
    }
}
