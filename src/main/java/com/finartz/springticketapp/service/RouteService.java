package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Route;

import java.time.LocalDate;
import java.util.List;

public interface RouteService {

    Route save(Route route);
    List<Route> getAll();
    Route getById(Long id);
    Route getByFlightFromAndFlightToAndDepartureDate(String flightFrom, String flightTo, LocalDate departureDate);
    Route getByFlightFromAndFlightTo(String flightFrom, String flightTo);
    Route getByDepartureDate(LocalDate departureDate);
}
