package com.example.JobApplication.company;

import java.util.*;

public interface CompanyService {

    //Define methods here...
    List<Company> getallCompanies();
    boolean updateCompany(Company company, Long id);
}
