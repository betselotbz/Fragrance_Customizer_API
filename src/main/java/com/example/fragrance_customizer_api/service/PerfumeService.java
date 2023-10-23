package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.Perfume;
import com.example.fragrance_customizer_api.model.User;
import com.example.fragrance_customizer_api.repository.PerfumeRepository;
import com.example.fragrance_customizer_api.repository.UserCartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    @Autowired
    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }
}
