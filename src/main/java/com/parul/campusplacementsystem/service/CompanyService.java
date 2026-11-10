package com.parul.campusplacementsystem.service;

import com.parul.campusplacementsystem.entity.Company;
import com.parul.campusplacementsystem.repository.CompanyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Save Company
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Get All Companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get Company By ID
    public Company getCompanyById(int id) {
        return companyRepository.findById(id).orElse(null);
    }

    // Update Company
    public Company updateCompany(Company company) {
        return companyRepository.save(company);
    }

    // Delete Company
    public void deleteCompany(int id) {
        companyRepository.deleteById(id);
    }
}