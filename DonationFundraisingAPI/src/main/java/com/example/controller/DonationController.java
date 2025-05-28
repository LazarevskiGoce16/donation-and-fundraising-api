package com.example.controller;

import com.example.entity.Donation;
import com.example.service.DonationService;
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
    public List<Donation> getAll() {
        return donationService.getAll();
    }

    @GetMapping("/campaigns/{campaignId}")
    public List<Donation> getAllDonationsByCampaign(@PathVariable Long campaignId) {
        return donationService.getDonationsForCampaign(campaignId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(donationService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Donation> create(@PathVariable Long campaignId, @RequestBody Donation donation) {
        return new ResponseEntity<>(donationService.donate(campaignId, donation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        donationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
