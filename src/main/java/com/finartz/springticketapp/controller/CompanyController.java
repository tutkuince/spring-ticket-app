package com.finartz.springticketapp.controller;

import com.finartz.springticketapp.entity.Company;
import com.finartz.springticketapp.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> companies = companyService.getAll();
        return ResponseEntity.ok(companies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.getById(id);
        return ResponseEntity.ok(company);
    }

    @GetMapping("/company")
    public ResponseEntity<Company> getCompanyByName(@RequestParam(value = "name") String name) {
        Company company = companyService.getByName(name);
        return ResponseEntity.ok(company);
    }
}
