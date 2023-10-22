package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository {
    Ingredient findByName(String name);
}
