package com.example.controller;

import com.example.dto.CampaignRequestDto;
import com.example.entity.Campaign;
import com.example.entity.Donation;
import com.example.service.CampaignService;
import com.example.service.DonationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaigns")
public class CampaignController {
    @Autowired
    private CampaignService campaignService;

    @Autowired
    private DonationService donationService;

    @GetMapping
    public List<Campaign> getAll() {
        return campaignService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getById(@PathVariable Long id) {
        return ResponseEntity.ok(campaignService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Campaign> create(@Valid @RequestBody CampaignRequestDto dto) {
        return new ResponseEntity<>(campaignService.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campaign> update(@Valid @PathVariable Long id, @RequestBody CampaignRequestDto dto) {
        return ResponseEntity.ok(campaignService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        campaignService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/donations")
    public List<Donation> getAllDonationsByCampaign(@PathVariable Long id) {
        return donationService.getDonationsForCampaign(id);
    }

    @GetMapping("/{id}/progress")
    public ResponseEntity<Double> getProgress(@PathVariable Long id) {
        return ResponseEntity.ok(campaignService.getProgress(id));
    }
}
