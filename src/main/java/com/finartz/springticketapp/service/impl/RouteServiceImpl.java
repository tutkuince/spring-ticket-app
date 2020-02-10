package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Route;
import com.finartz.springticketapp.repository.RouteRepository;
import com.finartz.springticketapp.service.RouteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getAll() {
        return routeRepository.findAll();
    }

    @Override
    public Route getById(Long id) {
        return routeRepository.getOne(id);
    }

    @Override
    public Route getByFlightFromAndFlightToAndDepartureDate(String flightFrom, String flightTo, LocalDate departureDate) {
        return routeRepository.getByFlightFromAndFlightToAndDepartureDate(flightFrom, flightTo, departureDate);
    }

    @Override
    public Route getByFlightFromAndFlightTo(String flightFrom, String flightTo) {
        return routeRepository.getByFlightFromAndFlightTo(flightFrom, flightTo);
    }

    @Override
    public Route getByDepartureDate(LocalDate departureDate) {
        return routeRepository.getByDepartureDate(departureDate);
    }
}
