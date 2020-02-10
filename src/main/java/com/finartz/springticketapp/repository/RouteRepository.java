package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RouteRepository extends JpaRepository<Route, Long> {

    Route getByFlightFromAndFlightToAndDepartureDate(String flightFrom, String flightTo, LocalDate departureDate);
    Route getByFlightFromAndFlightTo(String flightFrom, String flightTo);
    Route getByDepartureDate(LocalDate departureDate);
}
