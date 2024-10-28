package com.example.JobApplication.company.Implementation;
import com.example.JobApplication.company.Company;
import com.example.JobApplication.company.CompanyRepository;
import com.example.JobApplication.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getallCompanies() {
        return companyRepository.findAll();  //this method returns all the instance of the company in database
    }

    @Override
    public void createCompany(Company company) { //create company
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> jobOptional = companyRepository.findById(id);
        if (jobOptional.isPresent()) {
            Company companyToUpdate = jobOptional.get();
            //Update Logic
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;
        }
        return false;
    }
}
