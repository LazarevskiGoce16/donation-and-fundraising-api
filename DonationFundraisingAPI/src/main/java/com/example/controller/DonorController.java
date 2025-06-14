package com.example.controller;

import com.example.dto.DonorRequestDto;
import com.example.entity.Donor;
import com.example.service.DonorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @GetMapping
    public List<Donor> getAll() {
        return donorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getById(@PathVariable Long id) {
        return ResponseEntity.ok(donorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Donor> create(@Valid @RequestBody DonorRequestDto dto) {
        return new ResponseEntity<>(donorService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> update(@PathVariable Long id, @Valid @RequestBody DonorRequestDto dto) {
        return ResponseEntity.ok(donorService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        donorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
