package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.CompanyService;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /*@GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable("id") Long id) {
        return companyService.getCompany(id);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
    }*/
}
