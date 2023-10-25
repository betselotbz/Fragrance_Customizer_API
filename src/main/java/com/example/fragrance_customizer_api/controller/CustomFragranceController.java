package com.example.fragrance_customizer_api.controller;

import com.example.fragrance_customizer_api.model.CustomFragrance;
import com.example.fragrance_customizer_api.service.CustomFragranceService;
import com.example.fragrance_customizer_api.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("api/custom-fragrance")
public class CustomFragranceController {
    private final CustomFragranceService customFragranceService;

    @Autowired
    public CustomFragranceController(CustomFragranceService customFragranceService, IngredientService ingredientService) {
        this.customFragranceService = customFragranceService;
    }
    @GetMapping
    public List<CustomFragrance> getAllCustomFragrances() {
        return customFragranceService.getAllCustomFragrances();
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

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> createCustomFragrance(@RequestBody CustomFragrance customFragrance) {
        CustomFragrance createdCustomFragrance = customFragranceService.createCustomFragrance(customFragrance);
        HashMap<String, Object> response = new HashMap<>();

        if (createdCustomFragrance != null) {
            response.put("message", "Success");
            response.put("data", createdCustomFragrance);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Failed to create custom fragrance.");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> updateCustomFragrance(@PathVariable Long id, @RequestBody CustomFragrance customFragrance) {
        customFragrance.setId(id);
        CustomFragrance updatedCustomFragrance = customFragranceService.updateCustomFragrance(customFragrance);
        HashMap<String, Object> response = new HashMap<>();

        if (updatedCustomFragrance != null) {
            response.put("message", "Success");
            response.put("data", updatedCustomFragrance);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Cannot find any custom fragrance with the given ID.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomFragrance(@PathVariable Long id) {
        customFragranceService.deleteCustomFragrance(id);
        return ResponseEntity.noContent().build();
    }
}
