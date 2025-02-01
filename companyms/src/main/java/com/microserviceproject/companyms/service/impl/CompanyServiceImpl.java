package com.microserviceproject.companyms.service.impl;


import com.microserviceproject.companyms.model.Company;

import java.util.List;

public interface CompanyServiceImpl {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    boolean updateCompany(Long id, Company company);

    void addCompany(Company company);
    boolean removeCompany(Long id);
}
