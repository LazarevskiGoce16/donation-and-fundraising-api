package com.example.service;

import com.example.entity.Campaign;
import com.example.entity.Donation;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private CampaignService campaignService;

    public List<Donation> getDonationsForCampaign(Long campaignId) {
        return donationRepository.findByCampaignId(campaignId);
    }

    public Donation donate(Long campaignId, Donation donation) {
        Campaign campaign = campaignService.findById(campaignId);
        donation.setCampaign(campaign);
        donation.setDonationTime(LocalDateTime.now());

        campaign.setCollectedAmount(campaign.getCollectedAmount() + donation.getAmount());
        return donationRepository.save(donation);
    }

    public void delete(Long donationId) {
        donationRepository.deleteById(donationId);
    }

    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    public Donation getById(Long donationId) {
        return donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("Donation not found!"));
    }
}
