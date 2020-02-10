package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
