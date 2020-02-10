package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Company;
import com.finartz.springticketapp.entity.Flight;

import java.util.List;

public interface FlightService {

    Flight save(Flight flight);
    List<Flight> getByCompany(Company company);
}
