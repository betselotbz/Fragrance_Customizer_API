package com.example.fragrance_customizer_api.repository;

import com.example.fragrance_customizer_api.model.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PerfumeRepository extends JpaRepository<Perfume, Long> {
    Optional<Perfume> findByFamily(String family);
    Optional<Perfume> findById(Long Id);
    List<Perfume> findAll();
}
