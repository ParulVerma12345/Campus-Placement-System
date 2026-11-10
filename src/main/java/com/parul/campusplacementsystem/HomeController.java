package com.parul.campusplacementsystem;

import com.parul.campusplacementsystem.service.StudentService;
import com.parul.campusplacementsystem.service.CompanyService;
import com.parul.campusplacementsystem.service.PlacementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PlacementService placementService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("totalStudents",
                studentService.getAllStudents().size());

        model.addAttribute("totalCompanies",
                companyService.getAllCompanies().size());

        model.addAttribute("totalPlacements",
                placementService.getAllPlacements().size());

        long selectedStudents = placementService.getAllPlacements()
                .stream()
                .filter(p -> p.getStatus() != null &&
                        p.getStatus().equalsIgnoreCase("Selected"))
                .count();

        model.addAttribute("selectedStudents", selectedStudents);

        return "index";
    }
}