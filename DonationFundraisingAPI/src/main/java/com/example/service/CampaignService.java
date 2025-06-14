package com.example.service;

import com.example.dto.CampaignRequestDto;
import com.example.entity.Campaign;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepository campaignRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public List<Campaign> findAll() {
        return campaignRepository.findAll();
    }

    public Campaign findById(Long id) {
        return campaignRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign not found!"));
    }

    public Campaign create(CampaignRequestDto dto) {
        Campaign campaign = new Campaign();

        campaign.setTitle(dto.getTitle());
        campaign.setDescription(dto.getDescription());
        campaign.setGoalAmount(dto.getGoalAmount());
        campaign.setCollectedAmount(0);

        campaign.setStartDate(LocalDateTime.parse(dto.getStartDate(), formatter));
        campaign.setEndDate(LocalDateTime.parse(dto.getEndDate(), formatter));

        return campaignRepository.save(campaign);
    }

    public Campaign update(Long id, CampaignRequestDto dto) {
        Campaign campaign = findById(id);

        campaign.setTitle(dto.getTitle());
        campaign.setDescription(dto.getDescription());
        campaign.setGoalAmount(dto.getGoalAmount());

        campaign.setStartDate(LocalDateTime.parse(dto.getStartDate(), formatter));
        campaign.setEndDate(LocalDateTime.parse(dto.getEndDate(), formatter));

        return campaignRepository.save(campaign);
    }

    public void delete(Long id) {
        campaignRepository.deleteById(id);
    }

    public double getProgress(Long id) {
        Campaign campaign = findById(id);
        if (campaign.getGoalAmount() == 0) return 0;
        return (campaign.getCollectedAmount() / campaign.getGoalAmount()) * 100;
    }
}
