package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReceiptRequestDto {
    @NotNull(message = "Donation ID is required")
    @JsonAlias({"donation_id", "donationId"})
    private Long donationId;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @JsonAlias({"emailSentTo", "email_sent_to"})
    private String emailSentTo;

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public String getEmailSentTo() {
        return emailSentTo;
    }

    public void setEmailSentTo(String emailSentTo) {
        this.emailSentTo = emailSentTo;
    }
}
