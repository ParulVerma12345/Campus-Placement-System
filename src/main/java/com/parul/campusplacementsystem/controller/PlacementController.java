package com.parul.campusplacementsystem.controller;

import com.parul.campusplacementsystem.entity.Placement;
import com.parul.campusplacementsystem.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placement")
public class PlacementController {

    @Autowired
    private PlacementService placementService;

    @PostMapping("/save")
    public Placement savePlacement(@RequestBody Placement placement) {
        return placementService.savePlacement(placement);
    }

    @GetMapping("/all")
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @PutMapping("/update")
    public Placement updatePlacement(@RequestBody Placement placement) {
        return placementService.updatePlacement(placement);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlacement(@PathVariable int id) {
        placementService.deletePlacement(id);
        return "Placement Deleted Successfully";
    }
}