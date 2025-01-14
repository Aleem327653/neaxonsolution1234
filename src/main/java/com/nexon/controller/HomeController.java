package com.nexon.controller;

import com.nexon.model.Company;
import com.nexon.service.CompanysServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class HomeController {

    @Autowired
    private CompanysServiceImp serviceImp;
    @PostMapping
    public Company addCompany(@RequestBody Company company){
         return this.serviceImp.addCompany(company);
    }
}
