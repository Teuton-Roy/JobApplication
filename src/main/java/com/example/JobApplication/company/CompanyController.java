package com.example.JobApplication.company;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    //create object of companyService because controller will use the service object to work with company.

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //Get all the companies
    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getallCompanies();
    }


}
