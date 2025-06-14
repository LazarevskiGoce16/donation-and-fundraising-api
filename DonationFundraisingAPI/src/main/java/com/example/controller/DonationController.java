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

    // TODO: Move to campaign controller
//    @GetMapping
//    public List<Donation> getAllDonationsByCampaign(@PathVariable Long campaignId) {
//        return donationService.getDonationsForCampaign(campaignId);
//    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long campaignId, @PathVariable Long id) {
        donationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
