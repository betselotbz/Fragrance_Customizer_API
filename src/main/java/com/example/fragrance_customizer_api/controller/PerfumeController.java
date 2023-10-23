package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.Perfume;

import com.example.fragrance_customizer_api.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/perfumes")
public class PerfumeController {
    private final PerfumeService perfumeService;

    @Autowired
    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPerfumes() {
        List<Perfume> perfumeList = perfumeService.getAllPerfumes();
        HashMap<String, Object> message = new HashMap<>();

        if (perfumeList.isEmpty()) {
            message.put("message", "Cannot find any perfumes.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", perfumeList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerfumesById(@PathVariable Long id) {
        Optional<Perfume> optionalPerfume = perfumeService.getPerfumesById(id);
        HashMap<String, Object> message = new HashMap<>();
        if (optionalPerfume.isPresent()) {
            Perfume perfume = optionalPerfume.get();
            message.put("message", "Success");
            message.put("data", perfume);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Cannot find any perfume with the given ID.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{family}")
    public ResponseEntity<?> getIPerfumesByFamily(@PathVariable String family) {
        Optional<Perfume> optionalPerfume = perfumeService.getPerfumesByFamily(family);
        HashMap<String, Object> message = new HashMap<>();
        if (optionalPerfume.isPresent()) {
           Perfume perfume = optionalPerfume.get();
            message.put("message", "Success");
            message.put("data", perfume);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Cannot find any Perfume with the given family.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}