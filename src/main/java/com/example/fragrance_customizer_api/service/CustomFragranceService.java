package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomFragranceService {
    private final List<CustomFragrance> customFragranceList;

    @Autowired
    public CustomFragranceService(List<CustomFragrance> customFragranceList) {
        this.customFragranceList = customFragranceList;
    }
}
