package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Company;
import com.finartz.springticketapp.entity.Flight;
import com.finartz.springticketapp.repository.FlightRepository;
import com.finartz.springticketapp.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> getByCompany(Company company) {
        return flightRepository.getByCompany(company);
    }
}
