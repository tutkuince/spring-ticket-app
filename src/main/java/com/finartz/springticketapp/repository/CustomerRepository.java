package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
