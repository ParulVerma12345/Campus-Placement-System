package com.parul.campusplacementsystem.controller;

import com.parul.campusplacementsystem.entity.Company;
import com.parul.campusplacementsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/company")
    public class CompanyController {

        @Autowired
        private CompanyService companyService;

        // Save Company
        @PostMapping("/save")
        public Company saveCompany(@RequestBody Company company) {
            return companyService.saveCompany(company);
        }

        // Get All Companies
        @GetMapping("/all")
        public List<Company> getAllCompanies() {
            return companyService.getAllCompanies();
        }

        // Update Company
        @PutMapping("/update")
        public Company updateCompany(@RequestBody Company company) {
            return companyService.updateCompany(company);
        }

        // Delete Company
        @DeleteMapping("/delete/{id}")
        public String deleteCompany(@PathVariable int id) {
            companyService.deleteCompany(id);
            return "Company Deleted Successfully";
        }
    }

