package com.nexon.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    private Integer id;

    private String companyName;

    private String address;

    public Company() {
    }

    public Company(Integer id, String companyName, String address) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
