package com.microserviceproject.companyms.controller;

import com.microserviceproject.companyms.model.Company;
import com.microserviceproject.companyms.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompaniesController {

    @Autowired
    private CompanyServiceImpl companyService;
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCompanyDetails(@PathVariable Long companyId){
        Company company = companyService.getCompanyById(companyId);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<Object> getAllCompanyDetail(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Object> updateCompany(@PathVariable Long id, @RequestBody Company company){
        boolean isUpdated = companyService.updateCompany(id, company);
        if(isUpdated){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeCompany(@PathVariable Long id){
        boolean isDeleted = companyService.removeCompany(id);
        if(isDeleted){
            return  new ResponseEntity<>("", HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
