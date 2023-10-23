package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.Ingredient;
import com.example.fragrance_customizer_api.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
    Optional<Ingredient> findById(Long Id);
    List<Ingredient> findAll();
}
