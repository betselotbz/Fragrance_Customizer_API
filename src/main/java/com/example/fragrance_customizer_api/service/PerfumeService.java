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

    public List<Perfume> getAllPerfumesByFamily(String family) {
        return perfumeRepository.findAllByFamily(family);
    }

    public Optional<Perfume> getPerfumeById(Long id) {
        return perfumeRepository.findById(id);
    }

    public Perfume createPerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public Perfume updatePerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    public void deletePerfume(Long id) {
        perfumeRepository.deleteById(id);
    }
}