package com.parul.campusplacementsystem.service;

import com.parul.campusplacementsystem.entity.Placement;
import com.parul.campusplacementsystem.repository.PlacementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    // Save Placement
    public Placement savePlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    // Get All Placements
    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    // Get Placement By ID
    public Placement getPlacementById(int id) {
        return placementRepository.findById(id).orElse(null);
    }

    // Update Placement
    public Placement updatePlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    // Delete Placement
    public void deletePlacement(int id) {
        placementRepository.deleteById(id);
    }
}