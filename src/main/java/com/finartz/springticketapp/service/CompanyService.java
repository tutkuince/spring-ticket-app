package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Company;

import java.util.List;

public interface CompanyService {
    Company save(Company company);
    List<Company> getAll();
    Company getById(Long id);
    Company getByName(String name);
}
