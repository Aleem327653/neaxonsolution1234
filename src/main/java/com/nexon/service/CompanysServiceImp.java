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
        try{
            return repo.save(company);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Company fetchSingleCompany(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Company> findAllCompany() {
        return repo.findAll();
    }

    @Override
    public Company findByCompanyName(String companyName) {
        try{
            return repo.findByCompanyName(companyName);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public Company updateCompany(Company company, Integer id) {
        try {
            Company com = repo.findById(id).get();
            com.setCompanyName(company.getCompanyName());
            com.setAddress(company.getAddress());
            repo.save(com);
            return com;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteCompany(Integer id) {
        try{
            repo.deleteById(id);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
