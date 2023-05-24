package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.CompanyService;
import com.project.PlatformUM.api.models.Company;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getCompanies() {
        return this.companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable("id") Long id) {
        return this.companyService.getById(id);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return this.companyService.create(company);
    }

    /*@PutMapping("/{id}")
    public Company updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return companyService.update(id, company);
    }*/

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        this.companyService.delete(id);
    }
}
