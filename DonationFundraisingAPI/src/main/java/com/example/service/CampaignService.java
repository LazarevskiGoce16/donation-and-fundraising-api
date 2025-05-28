package com.example.service;

import com.example.entity.Campaign;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public Campaign findById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found!"));
    }

    public Campaign create(Campaign campaign) {
        return campaignRepository.save(campaign);
    }

    public Campaign update(Long id, Campaign updatedCampaign) {
        Campaign campaign = findById(id);
        campaign.setTitle(updatedCampaign.getTitle());
        campaign.setGoalAmount(updatedCampaign.getGoalAmount());
        campaign.setDescription(updatedCampaign.getDescription());
        return campaignRepository.save(campaign);
    }

    public void delete(Long id) {
        campaignRepository.deleteById(id);
    }

    public double getProgress(Long id) {
        Campaign campaign = findById(id);
        return (campaign.getCollectedAmount() / campaign.getGoalAmount()) * 100;
    }
}
