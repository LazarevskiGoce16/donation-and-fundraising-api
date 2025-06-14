package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class DonorRequestDto {
    @NotBlank(message = "Donor name is required!")
    @JsonAlias({"fullName", "full_name"})
    public String fullName;

    @Email(message = "Email should be valid!")
    @JsonProperty("email")
    public String email;

    @NotBlank(message = "Donor phone is required!")
    @JsonProperty("phone")
    public String phone;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
