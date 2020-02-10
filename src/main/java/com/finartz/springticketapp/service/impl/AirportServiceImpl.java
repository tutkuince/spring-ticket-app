package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Airport;
import com.finartz.springticketapp.repository.AirportRepository;
import com.finartz.springticketapp.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getById(Long id) {
        return airportRepository.getOne(id);
    }

    @Override
    public Airport getByName(String name) {
        return airportRepository.getByName(name);
    }
}
