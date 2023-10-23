package com.example.fragrance_customizer_api.service;

import com.example.fragrance_customizer_api.model.Perfume;
import com.example.fragrance_customizer_api.repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeService {
    private final List<Perfume> perfumeList;
    private PerfumeRepository perfumeRepository;

    @Autowired
    public void setPerfumeRepository(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }
    public PerfumeService(List<Perfume> perfumeList) {this.perfumeList = perfumeList;}
    
    
    
    
}

