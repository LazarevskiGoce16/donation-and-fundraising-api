package com.example.service;

import com.example.dto.DonorRequestDto;
import com.example.entity.Donor;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    private Donor getOrThrow(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donor not found!"));
    }

    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    public Donor findById(Long id) {
        return getOrThrow(id);
    }

    public Donor create(DonorRequestDto dto) {
        Donor donor = new Donor();

        donor.setFullName(dto.getFullName());
        donor.setEmail(dto.getEmail());
        donor.setPhone(dto.getPhone());

        return donorRepository.save(donor);
    }

    public Donor update(Long id, DonorRequestDto dto) {
        Donor existingDonor = getOrThrow(id);

        existingDonor.setFullName(dto.getFullName());
        existingDonor.setEmail(dto.getEmail());
        existingDonor.setPhone(dto.getPhone());

        return donorRepository.save(existingDonor);
    }

    public void delete(Long id) {
        donorRepository.deleteById(id);
    }
}
