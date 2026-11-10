package com.parul.campusplacementsystem.controller;

import com.parul.campusplacementsystem.entity.Placement;
import com.parul.campusplacementsystem.service.PlacementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PlacementPageController {

    @Autowired
    private PlacementService placementService;

    // Show All Placements
    @GetMapping("/placement")
    public String placementList(Model model) {

        model.addAttribute("placements",
                placementService.getAllPlacements());

        return "placement-list";
    }

    // Open Add Form
    @GetMapping("/placement/add")
    public String addPlacementPage(Model model) {

        model.addAttribute("placement", new Placement());

        return "placement-form";
    }

    // Save or Update Placement
    @PostMapping("/placement/page/save")
    public String savePlacement(Placement placement) {

        placementService.savePlacement(placement);

        return "redirect:/placement";
    }

    // Edit Placement
    @GetMapping("/placement/edit/{id}")
    public String editPlacement(@PathVariable int id, Model model) {

        Placement placement = placementService.getPlacementById(id);

        if (placement == null) {
            return "redirect:/placement";
        }

        model.addAttribute("placement", placement);

        return "placement-form";
    }

    // Delete Placement
    @GetMapping("/placement/delete/{id}")
    public String deletePlacement(@PathVariable int id) {

        placementService.deletePlacement(id);

        return "redirect:/placement";
    }
}