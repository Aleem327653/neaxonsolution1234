package com.nexon.controller;

import com.nexon.model.Company;
import com.nexon.service.CompanysServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class HomeController {

    @Autowired
    private CompanysServiceImp serviceImp;
    @PostMapping
    public Company addCompany(@RequestBody Company company)
    {
         return this.serviceImp.addCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompany(){
        return this.serviceImp.findAllCompany();
    }

    @GetMapping("/{id}")
    public Company singleCompnany(@PathVariable Integer id){

        return this.serviceImp.fetchSingleCompany(id);
    }

    @GetMapping("/{name}")
    public Company getCompany(@PathVariable String name){
        return this.serviceImp.findByCompanyName(name);
    }

    @PutMapping("/{id}")
    public Company updateCompany(@RequestBody Company com,@PathVariable Integer id){
        return this.serviceImp.updateCompany(com,id);
    }
}
