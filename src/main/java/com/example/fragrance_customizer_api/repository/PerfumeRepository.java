package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    Perfume findByFamily(String family);
}
