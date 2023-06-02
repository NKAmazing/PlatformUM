package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Company;
import com.project.PlatformUM.api.repositories.ICompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional; //Devuelve nulo o algo.
import java.util.ArrayList;


@Service
public class CompanyService {

    @Autowired
    ICompanyRepository companyRepository;

    public ArrayList<Company> getCompanies() {
        return (ArrayList<Company>) companyRepository.findAll();
    }

    public Optional<Company> getById(Long id) {
        return companyRepository.findById(id);
    }

    public Company create(Company company) {
        return companyRepository.save(company);
    }

    public Company updateById(Company request, Long id){
        Company company = companyRepository.findById(id).get();

        if (request.getName() != null) company.setName(request.getName());

        return companyRepository.save(company);
    }

    public Boolean deleteCompany (Long id) {
        try {
            companyRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}