package com.nexon.service;

import com.nexon.model.Company;
import com.nexon.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanysServiceImp implements CompanyService{
    @Autowired
    private CompanyRepository repo;
    @Override
    public Company addCompany(Company company) {
        return repo.save(company)
    }

    @Override
    public Company fetchSingleCompany(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Company> findAllCompany() {
        return repo.findAll();
    }
}
