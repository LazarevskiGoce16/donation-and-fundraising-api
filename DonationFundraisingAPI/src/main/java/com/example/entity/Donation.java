package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private LocalDateTime donationTime;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    @JsonIgnore
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    @JsonIgnore
    private Donor donor;

    @OneToOne(mappedBy = "donation", cascade = CascadeType.ALL)
    private Receipt receipt;

    public Donation() {
        this.donationTime = LocalDateTime.now();
    }

    public Donation(
            double amount,
            Campaign campaign,
            Donor donor) {
        this();
        this.amount = amount;
        this.campaign = campaign;
        this.donor = donor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(LocalDateTime donationTime) {
        this.donationTime = donationTime;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
        if (receipt != null && receipt.getDonation() != this) {
            receipt.setDonation(this);
        }
    }
}
