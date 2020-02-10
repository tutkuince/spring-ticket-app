package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
