package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Company;
import com.finartz.springticketapp.repository.CompanyRepository;
import com.finartz.springticketapp.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.getOne(id);
    }

    @Override
    public Company getByName(String name) {
        return companyRepository.getByName(name);
    }
}
