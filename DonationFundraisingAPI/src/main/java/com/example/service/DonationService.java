package com.example.service;

import com.example.dto.DonationRequestDto;
import com.example.entity.Campaign;
import com.example.entity.Donation;
import com.example.entity.Donor;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.DonationRepository;
import com.example.repository.DonorRepository;
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
    @Autowired
    private DonorRepository donorRepository;

    public List<Donation> getDonationsForCampaign(Long campaignId) {
        return donationRepository.findByCampaignId(campaignId);
    }

    public Donation donate(DonationRequestDto dto) {
        Campaign campaign = campaignService.findById(dto.getCampaignId());

        if (campaign == null) {
            throw new ResourceNotFoundException("Valid campaign must be provided");
        }

        Donor donor = donorRepository.findById(dto.getDonorId())
                .orElseThrow(() -> new ResourceNotFoundException("Donor not found"));

        System.out.println(campaign.getId() + campaign.getTitle());
        System.out.println(donor.getId() + donor.getFullName());

        Donation donation = new Donation(
                dto.getAmount(),
                campaign,
                donor
        );
         donationRepository.save(donation);
//        campaign.setCollectedAmount(campaign.getCollectedAmount() + donation.getAmount());

        return donation;
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
