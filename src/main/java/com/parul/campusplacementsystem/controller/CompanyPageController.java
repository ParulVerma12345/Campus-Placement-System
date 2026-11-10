package com.parul.campusplacementsystem.controller;

import com.parul.campusplacementsystem.entity.Company;
import com.parul.campusplacementsystem.service.CompanyService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CompanyPageController {

    @Autowired
    private CompanyService companyService;

    // Show All Companies
    @GetMapping("/company")
    public String companyList(Model model) {

        model.addAttribute("companies",
                companyService.getAllCompanies());

        return "company-list";
    }

    // Open Add Company Form
    @GetMapping("/company/add")
    public String addCompanyPage(Model model) {

        model.addAttribute("company", new Company());

        return "company-form";
    }

    // Save or Update Company with Validation
    @PostMapping("/company/page/save")
    public String saveCompany(
            @Valid Company company,
            BindingResult result) {

        if (result.hasErrors()) {
            return "company-form";
        }

        companyService.saveCompany(company);

        return "redirect:/company";
    }

    // Edit Company
    @GetMapping("/company/edit/{id}")
    public String editCompany(@PathVariable int id, Model model) {

        Company company = companyService.getCompanyById(id);

        if (company == null) {
            return "redirect:/company";
        }

        model.addAttribute("company", company);

        return "company-form";
    }

    // Delete Company
    @GetMapping("/company/delete/{id}")
    public String deleteCompany(@PathVariable int id) {

        companyService.deleteCompany(id);

        return "redirect:/company";
    }
}