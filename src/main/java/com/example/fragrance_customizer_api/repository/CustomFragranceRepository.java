package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomFragranceRepository extends JpaRepository <CustomFragrance, Long> {
    CustomFragrance findByNotes(String notes);
}
