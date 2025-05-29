package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {
    @GetMapping(produces = "text/plain")
    public String getStatus() {
        return "Donation and Fundraising API is Up and Running";
    }
}
