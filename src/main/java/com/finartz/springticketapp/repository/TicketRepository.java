package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Flight;
import com.finartz.springticketapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket getByTicketNumber(String ticketNumber);
    List<Ticket> getByFlight(Flight flight);
}
