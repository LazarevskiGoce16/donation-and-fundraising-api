package com.example.service;

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

    public List<Donor> findAll() {
        return donorRepository.findAll();
    }

    public Donor findById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donor not found!"));
    }

    public Donor create(Donor donor) {
        return donorRepository.save(donor);
    }

    public Donor update(Long id, Donor donorDetails) {
        Donor donor = donorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Donor not found!"));

        donor.setFullName(donorDetails.getFullName());
        donor.setEmail(donorDetails.getEmail());
        donor.setPhone(donorDetails.getPhone());
        return donorRepository.save(donor);
    }

    public void delete(Long id) {
        donorRepository.deleteById(id);
    }
}
