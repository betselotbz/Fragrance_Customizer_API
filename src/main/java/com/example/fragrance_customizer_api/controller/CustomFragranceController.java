package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import com.example.fragrance_customizer_api.service.CustomFragranceService;
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
@RequestMapping("api/custom-fragrance")
public class CustomFragranceController {
    private final CustomFragranceService customFragranceService;

    @Autowired
    public CustomFragranceController(CustomFragranceService customFragranceService) {
        this.customFragranceService = customFragranceService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllCustomFragrance() {
        List<CustomFragrance> customFragranceList = customFragranceService.getAllCustomFragrance();
        HashMap<String, Object> message = new HashMap<>();

        if (customFragranceList.isEmpty()) {
            message.put("message", "Cannot find any custom fragrances.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "Success");
            message.put("data", customFragranceList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomFragranceById(@PathVariable Long id) {
        Optional<CustomFragrance> optionalCustomFragrance = customFragranceService.getCustomFragranceById(id);
        HashMap<String, Object> message = new HashMap<>();
        if (optionalCustomFragrance.isPresent()) {
            CustomFragrance customFragrance = optionalCustomFragrance.get();
            message.put("message", "Success");
            message.put("data", customFragrance);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Cannot find any custom fragrance with the given ID.");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
