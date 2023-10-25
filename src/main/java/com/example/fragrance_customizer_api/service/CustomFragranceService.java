package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import com.example.fragrance_customizer_api.repository.CustomFragranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomFragranceService {

    private CustomFragranceRepository customFragranceRepository;
    @Autowired
    public void setCustomFragranceRepository(CustomFragranceRepository customFragranceRepository) {
        this.customFragranceRepository = customFragranceRepository;
    }
    public List<CustomFragrance> getAllCustomFragrances() {
        return customFragranceRepository.findAll();
    }

    public Optional<CustomFragrance> getCustomFragranceById(Long id) {
        return customFragranceRepository.findById(id);
    }

    public CustomFragrance createCustomFragrance(CustomFragrance customFragrance) {
        return customFragranceRepository.save(customFragrance);
    }

    public CustomFragrance updateCustomFragrance(CustomFragrance customFragrance) {
        return customFragranceRepository.save(customFragrance);
    }

    public void deleteCustomFragrance(Long id) {
        customFragranceRepository.deleteById(id);
    }

}
