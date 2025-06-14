package com.example.controller;

import com.example.dto.DonationRequestDto;
import com.example.entity.Donation;
import com.example.service.DonationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {
    @Autowired
    private DonationService donationService;

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getById(@PathVariable Long id) {
        Donation donation = donationService.getById(id);
        return ResponseEntity.ok(donation);
    }

    @PostMapping
    public ResponseEntity<Donation> create(@Valid @RequestBody DonationRequestDto dto) {
        return new ResponseEntity<>(donationService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donation> update(@PathVariable Long id, @Valid @RequestBody DonationRequestDto dto) {
        return ResponseEntity.ok(donationService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        donationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
