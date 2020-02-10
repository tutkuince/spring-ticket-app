package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Ticket;
import com.finartz.springticketapp.repository.TicketRepository;
import com.finartz.springticketapp.service.TicketService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getByTicketNumber(String ticketNumber) {
        return ticketRepository.getByTicketNumber(ticketNumber);
    }

    @Override
    public BigDecimal calculateTicketPrice() {
        // TODO - Calculate ticket price
        return null;
    }

    @Override
    public Ticket buyTicket() {
        // TODO - Buy ticket
        return null;
    }

    @Override
    public Ticket cancelTicket(Ticket ticket) {
        // TODO - Cancel ticket
        return null;
    }
}
