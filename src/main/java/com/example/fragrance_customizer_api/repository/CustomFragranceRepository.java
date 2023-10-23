package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import com.example.fragrance_customizer_api.model.Perfume;
import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.model.UserCartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomFragranceRepository extends JpaRepository <CustomFragrance, Long> {
    Optional<CustomFragrance> findByFamily(String family);
    Optional<CustomFragrance> findByNotes(String notes);
    Optional<CustomFragrance> findById(Long Id);
    List<CustomFragrance> findAll();

}
