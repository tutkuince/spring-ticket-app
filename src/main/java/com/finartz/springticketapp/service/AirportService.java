package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Airport;

import java.util.List;

public interface AirportService {
    Airport save(Airport airport);
    List<Airport> getAll();
    Airport getById(Long id);
    Airport getByName(String name);
}
