package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Customer;
import com.finartz.springticketapp.repository.CustomerRepository;
import com.finartz.springticketapp.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
