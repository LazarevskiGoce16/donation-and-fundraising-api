package com.example.service;

import com.example.dto.DonationRequestDto;
import com.example.entity.Campaign;
import com.example.entity.Donation;
import com.example.entity.Donor;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    @Autowired
    private DonationRepository donationRepository;
    @Autowired
    private CampaignService campaignService;
    @Autowired
    private DonorService donorService;

    public List<Donation> getDonationsForCampaign(Long campaignId) {
        return donationRepository.findByCampaignId(campaignId);
    }

    public Donation create(DonationRequestDto dto) {
        Campaign campaign = campaignService.findById(dto.getCampaignId());

        if (campaign == null) {
            throw new ResourceNotFoundException("Valid campaign must be provided");
        }

        Donor donor = donorService.findById(dto.getDonorId());

        if (donor == null) {
            throw new ResourceNotFoundException("Valid donor must be provided");
        }

        Donation donation = new Donation(
                dto.getAmount(),
                campaign,
                donor
        );
         donationRepository.save(donation);

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
