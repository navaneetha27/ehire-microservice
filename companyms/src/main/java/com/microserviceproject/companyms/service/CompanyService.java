package com.microserviceproject.companyms.service;


import com.microserviceproject.companyms.model.Company;
import com.microserviceproject.companyms.repository.CompanyRepository;
import com.microserviceproject.companyms.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceImpl {
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            return company.get();
        }
        return null;
    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean removeCompany(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return  true;
        }
        return false;
    }



}
