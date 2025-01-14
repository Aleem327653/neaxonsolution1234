package com.nexon.service;

import com.nexon.model.Company;

import java.util.List;

public interface CompanyService {
    public Company addCompany(Company company);
    public Company fetchSingleCompany(Integer id);
    public List<Company> findAllCompany();
}
