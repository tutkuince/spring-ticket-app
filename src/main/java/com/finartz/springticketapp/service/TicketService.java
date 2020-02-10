package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Ticket;

import java.math.BigDecimal;

public interface TicketService {

    Ticket save(Ticket ticket);
    Ticket getByTicketNumber(String ticketNumber);
    String generateTicketNumber();
    BigDecimal calculateTicketPrice();
    Ticket cancelTicket(Ticket ticket);
}
