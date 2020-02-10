package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Ticket;

import java.math.BigDecimal;

public interface TicketService {

    Ticket save(Ticket ticket);
    Ticket getByTicketNumber(String ticketNumber);
    BigDecimal calculateTicketPrice();
    Ticket buyTicket();
    Ticket cancelTicket(Ticket ticket);
}
