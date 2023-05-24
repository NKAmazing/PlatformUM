package com.project.PlatformUM.api.services;

import com.project.PlatformUM.api.models.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyService implements IService<Company> {

    public CompanyService() {
    }

    @Override
    public List<Company> getAll() {
        return new ArrayList<Company>();
    }

    @Override
    public Company getById(Long id) {
        return new Company();
    }

    @Override
    public Company create(Company company) {
        return new Company();
    }

    @Override
    public Company update(Company company) {
        return new Company();
    }

    @Override
    public void delete(Long id) {
    }

}