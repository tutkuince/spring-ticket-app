package com.finartz.springticketapp.controller;

import com.finartz.springticketapp.entity.Route;
import com.finartz.springticketapp.service.RouteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@Valid @RequestBody Route route) {
        routeService.save(route);
        return ResponseEntity.ok(route);
    }

    @GetMapping
    public ResponseEntity<List<Route>> getRoutes() {
        List<Route> routes = routeService.getAll();
        return ResponseEntity.ok(routes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Route route = routeService.getById(id);
        return ResponseEntity.ok(route);
    }

    @GetMapping(value = "/route", params = {"flightFrom", "flightTo", "departureDate"})
    public ResponseEntity<Route> getRouteByFlightFromAndFlightToAndDepartureDate(
            @RequestParam(name = "flightFrom") String flightFrom,
            @RequestParam(name = "flightTo") String flightTo,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(name = "departureDate") LocalDate departureDate
    ) {

        Route route = routeService.getByFlightFromAndFlightToAndDepartureDate(flightFrom, flightTo, departureDate);
        return ResponseEntity.ok(route);
    }

    @GetMapping(value = "/route", params = {"flightFrom", "flightTo"})
    public ResponseEntity<Route> getRouteByFlightFromAndFlightTo(
            @RequestParam(name = "flightFrom") String flightFrom,
            @RequestParam(name = "flightTo") String flightTo
    ) {

        Route route = routeService.getByFlightFromAndFlightTo(flightFrom, flightTo);
        return ResponseEntity.ok(route);
    }

    @GetMapping(value = "/route", params = {"departureDate"})
    public ResponseEntity<Route> getRouteByDepartureDate(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(name = "departureDate") LocalDate departureDate
    ) {

        Route route = routeService.getByDepartureDate(departureDate);
        return ResponseEntity.ok(route);
    }
}
