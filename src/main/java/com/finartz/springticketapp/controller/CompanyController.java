package com.finartz.springticketapp.controller;

import com.finartz.springticketapp.entity.Company;
import com.finartz.springticketapp.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
        companyService.save(company);
        return ResponseEntity.ok(company);
    }
}
