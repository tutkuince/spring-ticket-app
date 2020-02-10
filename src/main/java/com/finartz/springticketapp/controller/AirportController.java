package com.finartz.springticketapp.controller;

import com.finartz.springticketapp.entity.Airport;
import com.finartz.springticketapp.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping
    public ResponseEntity<Airport> createAirport(@Valid @RequestBody Airport airport) {
        airportService.save(airport);
        return ResponseEntity.ok(airport);
    }

    @GetMapping
    public ResponseEntity<List<Airport>> getAirports() {
        List<Airport> airports = airportService.getAll();
        return ResponseEntity.ok(airports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Long id) {
        Airport airport = airportService.getById(id);
        return ResponseEntity.ok(airport);
    }

    @GetMapping("/airport")
    public ResponseEntity<Airport> getAirportByName(@RequestParam(value = "name") String name) {
        Airport airport = airportService.getByName(name);
        return ResponseEntity.ok(airport);
    }

}
