package com.project.PlatformUM.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.PlatformUM.api.services.CompanyService;
import com.project.PlatformUM.api.models.Company;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getCompanies() {
        return this.companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Optional<Company> getCompany(@PathVariable("id") Long id) {
        return this.companyService.getById(id);
    }

    @PostMapping
    public Company addCompany(@RequestBody Company company) {
        return this.companyService.create(company);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
        return this.companyService.updateById(company, id);
    }

    @DeleteMapping("/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        boolean isDeleted = this.companyService.deleteCompany(id);

        if (isDeleted) {
            return "Company with id " + id + " was deleted.";
        } else {
            return "Company with id " + id + " was not deleted.";
        }
    }
}
