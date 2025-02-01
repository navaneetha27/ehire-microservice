package com.microserviceproject.companyms.repository;

import com.microserviceproject.companyms.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository  extends JpaRepository<Company,Long> {
}
