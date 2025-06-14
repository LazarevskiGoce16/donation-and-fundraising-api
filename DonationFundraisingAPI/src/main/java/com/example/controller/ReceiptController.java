package com.example.controller;

import com.example.dto.ReceiptRequestDto;
import com.example.entity.Receipt;
import com.example.service.ReceiptService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @GetMapping
    public List<Receipt> getAll() {
        return receiptService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receipt> getById(@PathVariable Long id) {
        return ResponseEntity.ok(receiptService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Receipt> create(@Valid @RequestBody ReceiptRequestDto dto) {
        return new ResponseEntity<>(receiptService.create(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        receiptService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
