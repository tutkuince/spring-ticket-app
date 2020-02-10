package com.finartz.springticketapp.controller;

import com.finartz.springticketapp.entity.*;
import com.finartz.springticketapp.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
@RequestMapping("/api/dummy")
public class DummyData {

    private final AirportService airportService;
    private final CompanyService companyService;
    private final RouteService routeService;
    private final FlightService flightService;
    private final TicketService ticketService;

    public DummyData(AirportService airportService,
                     CompanyService companyService,
                     RouteService routeService,
                     FlightService flightService,
                     TicketService ticketService) {
        this.airportService = airportService;
        this.companyService = companyService;
        this.routeService = routeService;
        this.flightService = flightService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public String addDummyData() {
        // Airport
        Airport airport1 = new Airport();
        airport1.setName("Adnan Menderes Airport");
        airport1.setDescription("İzmir Adnan Menderes Airport is an international airport serving İzmir");
        airport1.setAddress("Dokuz Eylül, 35410 Gaziemir/İzmir");

        Airport airport2 = new Airport();
        airport2.setName("Sabiha Gokcen International Airport");
        airport2.setDescription("Istanbul Sabiha Gökçen International Airport is one of two international airports serving Istanbul");
        airport2.setAddress("Sanayi, 34906 Pendik/İstanbul");

        // save airports to db
        airportService.save(airport1);
        airportService.save(airport2);


        // Company
        Company company1 = new Company();
        company1.setName("Turkish Airline");
        company1.setAirlineCode("THY");
        company1.setDescription("Turkish Airline Global");
        company1.setContactNumber("555 555 55 55");

        Company company2 = new Company();
        company2.setName("Pegasus");
        company2.setAirlineCode("FPGS");
        company2.setDescription("Fly Pegasus");
        company2.setContactNumber("333 333 55 55");

        Company company3 = new Company();
        company3.setName("Onur air");
        company3.setAirlineCode("AAI");
        company3.setDescription("Onur air global");
        company3.setContactNumber("111 111 55 55");

        //  save companies to db
        companyService.save(company1);
        companyService.save(company2);
        companyService.save(company3);

        // Companies
        Set<Company> companies1 = new HashSet<>();
        companies1.add(company1);
        companies1.add(company2);

        Set<Company> companies2 = new HashSet<>();
        companies2.add(company1);
        companies2.add(company2);
        companies2.add(company3);

        // set companies to airports
        airport1.setCompanies(companies2);
        airport2.setCompanies(companies1);

        // save
        airportService.save(airport1);
        airportService.save(airport2);


        // Routes
        Route route1 = new Route();
        route1.setFlightFrom("İzmir");
        route1.setFlightTo("İstanbul");
        route1.setDepartureDate(LocalDate.now().plusDays(1));

        Route route2 = new Route();
        route2.setFlightFrom("İstanbul");
        route2.setFlightTo("İzmir");
        route2.setDepartureDate(LocalDate.now().plusDays(1));

        // save routes to db
        routeService.save(route1);
        routeService.save(route2);

        // Flights
        Flight flight1 = new Flight();
        flight1.setTime(LocalDateTime.now().plusDays(1).minusHours(3));
        flight1.setFlightQuota(10);
        flight1.setRoute(route1);
        flight1.setCompany(company1);

        Flight flight2 = new Flight();
        flight2.setTime(LocalDateTime.now().plusDays(1).minusHours(6));
        flight2.setFlightQuota(10);
        flight2.setRoute(route1);
        flight2.setCompany(company2);

        Flight flight3 = new Flight();
        flight3.setTime(LocalDateTime.now().plusDays(1).minusHours(2));
        flight3.setFlightQuota(20);
        flight3.setRoute(route2);
        flight3.setCompany(company1);

        Flight flight4 = new Flight();
        flight4.setTime(LocalDateTime.now().plusDays(1).minusHours(6));
        flight4.setFlightQuota(20);
        flight4.setRoute(route2);
        flight4.setCompany(company3);


        // save flights to db
        flightService.save(flight1);
        flightService.save(flight2);
        flightService.save(flight3);
        flightService.save(flight4);

        // Ticket
        // Generate ticket for Flight-1
        for (int i = 0; i < flight1.getFlightQuota(); i++) {
            Ticket ticket = new Ticket();
            ticket.setPrice(new BigDecimal(100));
            ticket.setGate(1);
            ticket.setSeat("" + (i + 1));
            ticket.setFlight(flight1);
            ticketService.save(ticket);
        }

        for (int i = 0; i < flight2.getFlightQuota(); i++) {
            Ticket ticket = new Ticket();
            ticket.setPrice(new BigDecimal(200));
            ticket.setGate(2);
            ticket.setSeat("" + (i + 1));
            ticket.setFlight(flight2);
            ticketService.save(ticket);
        }

        for (int i = 0; i < flight3.getFlightQuota(); i++) {
            Ticket ticket = new Ticket();
            ticket.setPrice(new BigDecimal(100));
            ticket.setGate(3);
            ticket.setSeat("" + (i + 1));
            ticket.setFlight(flight3);
            ticketService.save(ticket);
        }

        for (int i = 0; i < flight4.getFlightQuota(); i++) {
            Ticket ticket = new Ticket();
            ticket.setPrice(new BigDecimal(300));
            ticket.setGate(4);
            ticket.setSeat("" + (i + 1));
            ticket.setFlight(flight4);
            ticketService.save(ticket);
        }

        Ticket ticket1 = ticketService.getById(1L);
        ticketService.buyTicket(ticket1);


        Ticket ticket2 = ticketService.getById(2L);
        ticketService.buyTicket(ticket2);


        ticketService.cancelTicket(ticket2);
        ticketService.cancelTicket(ticket1);

        return "start";
    }
}
