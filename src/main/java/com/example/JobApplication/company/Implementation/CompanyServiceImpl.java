package com.example.JobApplication.company.Implementation;

import com.example.JobApplication.company.Company;
import com.example.JobApplication.company.CompanyRepository;
import com.example.JobApplication.company.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getallCompanies() {
        return companyRepository.findAll();  //this method returns all the instance of the company in database
    }
}
