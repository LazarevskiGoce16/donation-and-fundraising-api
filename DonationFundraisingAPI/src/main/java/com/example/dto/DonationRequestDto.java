package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DonationRequestDto {
    @NotNull
    @Positive(message = "Amount must be greater than zero")
    @JsonProperty("amount")
    private double amount;

    @NotNull(message = "Donor ID cannot be null")
    @JsonAlias({"donor_id", "donorId"})
    private Long donorId;

    @NotNull(message = "Campaign ID cannot be null")
    @JsonAlias({"campaign_id", "campaignId"})
    private Long campaignId;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }
}
