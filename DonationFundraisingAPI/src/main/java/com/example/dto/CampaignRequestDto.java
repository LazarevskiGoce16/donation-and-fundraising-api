package com.example.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CampaignRequestDto {
    @NotBlank(message = "Title is required!")
    @JsonProperty("title")
    private String title;

    @NotBlank(message = "Description is required!")
    @JsonProperty("description")
    private String description;

    @NotNull
    @Positive(message = "Goal amount must be positive!")
    @JsonAlias({"goalAmount", "goal_amount"})
    private Double goalAmount;

    @NotBlank(message = "Start date is required")
    @JsonAlias({"startDate", "start_date"})
    private String startDate;

    @NotBlank(message = "End date is required")
    @JsonAlias({"endDate", "end_date"})
    private String endDate;

    public @NotBlank(message = "Title is required!") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required!") String title) {
        this.title = title;
    }

    public @NotBlank(message = "Description is required!") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank(message = "Description is required!") String description) {
        this.description = description;
    }

    public @NotNull @Positive(message = "Goal amount must be positive!") Double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(@NotNull @Positive(message = "Goal amount must be positive!") Double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public @NotBlank(message = "Start date is required") String getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotBlank(message = "Start date is required") String startDate) {
        this.startDate = startDate;
    }

    public @NotBlank(message = "End date is required") String getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotBlank(message = "End date is required") String endDate) {
        this.endDate = endDate;
    }
}
