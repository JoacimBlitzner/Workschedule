package com.patrik.joacim.Workschedule.controller;


import com.patrik.joacim.Workschedule.model.Company;
import com.patrik.joacim.Workschedule.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
public class CompanyController {

    private final CompanyRepository companyRepository;

    CompanyController(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }

    @GetMapping("/company")
    List<Company> all(){
        return companyRepository.findAll();
    }

    @PostMapping("/addcompany")
    Company newCompany(@RequestBody Company newCompany){
        return companyRepository.save(newCompany);
    }

    @GetMapping("/company/{id}")
    Company one(@PathVariable Long id) {

        return companyRepository.findById(id)
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @PutMapping("/company/{id}")
    Company replaceCompany(@RequestBody Company newCompany, @PathVariable Long id) {

        return companyRepository.findById(id)
                .map(company -> {
                    company.setCompanyName(newCompany.getCompanyName());
                    company.setAddress(newCompany.getAddress());
                    company.setContact(newCompany.getContact());
                    return companyRepository.save(company);
                })
                .orElseGet(() -> {
                    newCompany.setCompanyId(id);
                    return companyRepository.save(newCompany);
                });
    }

    @DeleteMapping("/company/{id}")
    void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }
}
