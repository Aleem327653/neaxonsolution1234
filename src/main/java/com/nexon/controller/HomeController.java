package com.nexon.controller;

import com.nexon.model.Company;
import com.nexon.service.CompanysServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class HomeController {

    @Autowired
    private CompanysServiceImp serviceImp;
    @PostMapping
    public ResponseEntity<Company> addCompany(@RequestBody Company company)
    {
       Company c= this.serviceImp.addCompany(company);
       if(c!=null){
           return new ResponseEntity<>(c, HttpStatus.CREATED);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
       }
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> ls= this.serviceImp.findAllCompany();
        if(ls.size()>0){
            return new ResponseEntity<>(ls,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Company> singleCompnany(@PathVariable Integer id){

        Company c=this.serviceImp.fetchSingleCompany(id);
        if(c!=null){
            return new ResponseEntity<>(c, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/companyname/{name}")
    public ResponseEntity<Company> getCompany(@PathVariable String name){
        Company c= this.serviceImp.findByCompanyName(name);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Company> updateCompany(@RequestBody Company com,@PathVariable Integer id){
        Company c= this.serviceImp.updateCompany(com,id);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Integer id){
        try{
            this.serviceImp.deleteCompany(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }
}
