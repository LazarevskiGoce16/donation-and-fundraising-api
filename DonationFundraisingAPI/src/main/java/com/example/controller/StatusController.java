package com.example.controller;

import com.example.dto.StatusDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @GetMapping
    public StatusDto getStatus() {
        return new StatusDto("Donation and Fundraising API", "Up and Running");
    }
}
