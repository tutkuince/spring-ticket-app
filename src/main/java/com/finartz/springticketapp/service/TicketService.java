package com.finartz.springticketapp.service;

import com.finartz.springticketapp.entity.Ticket;

public interface TicketService {

    Ticket save(Ticket ticket);
    Ticket getByTicketNumber(String ticketNumber);
    Ticket getById(Long id);
    void calculateTicketPrice(Ticket ticket, long emptyTicketCount);
    Ticket buyTicket(Ticket ticket);
    Ticket cancelTicket(Ticket ticket);
}
