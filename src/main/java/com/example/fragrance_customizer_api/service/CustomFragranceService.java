package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import com.example.fragrance_customizer_api.repository.CustomFragranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomFragranceService {
    private final List<CustomFragrance> customFragranceList;

    private CustomFragranceRepository customFragranceRepository;
    @Autowired
    public void setCustomFragranceRepository(CustomFragranceRepository customFragranceRepository) {
        this.customFragranceRepository = customFragranceRepository;
    }
    public CustomFragranceService(List<CustomFragrance> customFragranceList) {this.customFragranceList = customFragranceList;}

    public List<CustomFragrance> getAllCustomFragrance() {return customFragranceRepository.findAll();}

    public Optional<CustomFragrance> getCustomFragranceByNotes(String notes) { return customFragranceRepository.findByNotes(notes);}
    public Optional<CustomFragrance> getCustomFragranceByFamily(String family) { return customFragranceRepository.findByFamily(family);}
    public Optional<CustomFragrance> getCustomFragranceById(Long Id) {
        return customFragranceRepository.findById(Id);
    }
}
