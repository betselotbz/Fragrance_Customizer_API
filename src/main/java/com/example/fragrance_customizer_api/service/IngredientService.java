package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.Ingredient;
import com.example.fragrance_customizer_api.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final List<Ingredient> ingredientList;

    private IngredientRepository ingredientRepository;

    @Autowired
    public void setPerfumeRepository(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    public IngredientService(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
