package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.Perfume;
import com.example.fragrance_customizer_api.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    @Autowired
    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAll();
    }

    public Optional<Perfume> getPerfumeByFamily(String family) {
        return perfumeRepository.findByFamily(family);
    }

    public Optional<Perfume> getPerfumesById(Long id) {
        return perfumeRepository.findById(id);
    }
}
