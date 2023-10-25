package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.Perfume;

import com.example.fragrance_customizer_api.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/perfumes")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfumeController {
    private final PerfumeService perfumeService;

    @Autowired
    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @GetMapping("/")
    public List<Perfume> getAllPerfumes(@RequestParam(value = "family", required = false) String family) {
        if (family == null){
            return perfumeService.getAllPerfumes();
        }
        return perfumeService.getAllPerfumesByFamily(family);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfume> getPerfumeById(@PathVariable Long id) {
        return perfumeService.getPerfumeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/family/{family}")
    public ResponseEntity<?> getAllPerfumesByFamily(@PathVariable String family) {
        List<Perfume> perfumes = perfumeService.getAllPerfumesByFamily(family);
        HashMap<String, Object> response = new HashMap<>();

        if (perfumes.isEmpty()) {
            response.put("message", "Cannot find any perfumes for the given family.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        } else {
            response.put("message", "Success");
            response.put("data", perfumes);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PostMapping
    public Perfume createPerfume(@RequestBody Perfume perfume) {
        return perfumeService.createPerfume(perfume);
    }

    @PutMapping("/{id}")
    public Perfume updatePerfume(@PathVariable Long id, @RequestBody Perfume perfume) {
        perfume.setId(id);
        return perfumeService.updatePerfume(perfume);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerfume(@PathVariable Long id) {
        perfumeService.deletePerfume(id);
        return ResponseEntity.noContent().build();
    }
}