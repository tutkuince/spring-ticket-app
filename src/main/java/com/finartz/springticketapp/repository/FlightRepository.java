package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Company;
import com.finartz.springticketapp.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> getByCompany(Company company);
}
