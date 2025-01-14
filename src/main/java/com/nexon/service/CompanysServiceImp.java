package com.nexon.service;

import com.nexon.model.Company;
import com.nexon.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanysServiceImp implements CompanyService{
    @Autowired
    private CompanyRepository repo;
    @Override
    public Company addCompany(Company company) {
        return repo.save(company);
    }

    @Override
    public Company fetchSingleCompany(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Company> findAllCompany() {
        return repo.findAll();
    }

    @Override
    public Company findByCompanyName(String companyName) {
        return repo.findByCompanyName(companyName);
    }

    @Override
    public Company updateCompany(Company company, Integer id) {
        Company com=repo.findById(id).get();
        com.setCompanyName(company.getCompanyName());
        com.setAddress(company.getAddress());
        repo.save(com);
        return com;
    }
}
