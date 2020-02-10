package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport getByName(String name);
}
