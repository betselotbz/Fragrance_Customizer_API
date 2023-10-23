package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import com.example.fragrance_customizer_api.repository.CustomFragranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomFragranceService {
    private final List<CustomFragrance> customFragranceList;

    private CustomFragranceRepository customFragranceRepository;
    @Autowired
    public void setCustomFragranceRepository(CustomFragranceRepository customFragranceRepository) {
        this.customFragranceRepository = customFragranceRepository;
    }

}
