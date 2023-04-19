package com.patrik.joacim.Workschedule.controller;


import com.patrik.joacim.Workschedule.model.Company;
import com.patrik.joacim.Workschedule.model.Course;
import com.patrik.joacim.Workschedule.repository.CompanyRepository;
import com.patrik.joacim.Workschedule.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://127.0.0.1:5500/")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    CompanyController(CompanyRepository companyRepository, CourseRepository courseRepository){
        this.companyRepository=companyRepository;
        this.courseRepository=courseRepository;
    }

    @GetMapping("/company")
    List<Company> allCompany(){
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
    Company editCompany(@RequestBody Company newCompany, @PathVariable Long id) {

        return companyRepository.findById(id)
                .map(company -> {
                    company.setCompanyName(newCompany.getCompanyName());
                    company.setAddress(newCompany.getAddress());
                    company.setContact(newCompany.getContact());
                    return companyRepository.save(company);
                })
                .orElseThrow(() -> new CompanyNotFoundException(id));
    }

    @DeleteMapping("/company/{id}")
    void deleteCompany(@PathVariable Long id) {
        companyRepository.deleteById(id);
    }

    @GetMapping("/company/companycourse/{id}")
    public List<Course> companyCourse(@PathVariable("id") Long id){
        return courseRepository.findCourseByCompany_CompanyId(id);
    }
}
