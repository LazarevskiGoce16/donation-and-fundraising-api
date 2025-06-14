package com.example.service;

import com.example.dto.ReceiptRequestDto;
import com.example.entity.Donation;
import com.example.entity.Receipt;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private DonationService donationService;

    public Receipt create(ReceiptRequestDto dto) {
        Donation donation = donationService.getById(dto.getDonationId());

        Receipt receipt = new Receipt(
                dto.getEmailSentTo(),
                LocalDateTime.now(),
                donation
        );

        return receiptRepository.save(receipt);
    }

    public List<Receipt> getAll() {
        return receiptRepository.findAll();
    }

    public Receipt getById(Long id) {
        return receiptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receipt not found!"));
    }

    public void delete(Long id) {
        receiptRepository.deleteById(id);
    }
}
