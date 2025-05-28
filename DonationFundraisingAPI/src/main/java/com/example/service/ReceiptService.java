package com.example.service;

import com.example.entity.Donation;
import com.example.entity.Receipt;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.DonationRepository;
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
    private DonationRepository donationRepository;

    public Receipt createReceipt(Long donationId, String email) {
        Donation donation = donationRepository.findById(donationId)
                .orElseThrow(() -> new ResourceNotFoundException("Donation not found!"));

        Receipt receipt = new Receipt();
        receipt.setDonation(donation);
        receipt.setEmailSentTo(email);
        receipt.setSentDate(LocalDateTime.now());

        // TODO: Add real email sending in future versions

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