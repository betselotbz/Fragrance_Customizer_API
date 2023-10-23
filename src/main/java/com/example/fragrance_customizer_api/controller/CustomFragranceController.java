package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.service.CustomFragranceService;
import com.example.fragrance_customizer_api.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/custom-fragrance")
public class CustomFragranceController {
    private final CustomFragranceService customFragranceService;

    @Autowired
    public CustomFragranceController(CustomFragranceService customFragranceService) {
        this.customFragranceService = customFragranceService;
    }
}
