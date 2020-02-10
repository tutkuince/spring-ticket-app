package com.finartz.springticketapp.service.impl;

import com.finartz.springticketapp.entity.Flight;
import com.finartz.springticketapp.entity.Ticket;
import com.finartz.springticketapp.repository.FlightRepository;
import com.finartz.springticketapp.repository.TicketRepository;
import com.finartz.springticketapp.service.TicketService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, FlightRepository flightRepository) {
        this.ticketRepository = ticketRepository;
        this.flightRepository = flightRepository;
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
    public Ticket getById(Long id) {
        return ticketRepository.getOne(id);
    }

    @Override
    public void calculateTicketPrice(Ticket ticket, long emptyTicketCount) {
        long ticketCount = ticketRepository.getByFlight(ticket.getFlight()).size();
        long notEmptyTicketCount = ticketCount - emptyTicketCount;

        if (notEmptyTicketCount * 100 / ticketCount == 10) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 20) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 30) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 40) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 50) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 60) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 70) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 80) {
            calculateTicketAfterBuy(ticket);
        } else if (notEmptyTicketCount * 100 / ticketCount == 90) {
            calculateTicketAfterBuy(ticket);
        } else {
            calculateTicketAfterBuy(ticket);
        }
    }

    private void calculateTicketAfterBuy(Ticket ticket) {
        for (Ticket updateTicket: ticketRepository.getByFlight(ticket.getFlight())) {
            if (updateTicket.isEmpty()) {
                long oldPrice = updateTicket.getPrice().longValue();
                long percentage = (oldPrice * 10) / 100;
                long newPrice = percentage + oldPrice;
                updateTicket.setPrice(new BigDecimal(newPrice));
                ticketRepository.save(updateTicket);
            }
        }
    }

    private void calculateTicketAfterCancel(Ticket ticket) {

        for (Ticket updateTicket: ticketRepository.getByFlight(ticket.getFlight())) {
            if (updateTicket.isEmpty()) {
                long oldPrice = updateTicket.getPrice().longValue();
                long percentage = (oldPrice * 10) / 100;
                long newPrice = oldPrice - percentage + 1;
                updateTicket.setPrice(new BigDecimal(newPrice));
                ticketRepository.save(updateTicket);
            }
        }
    }

    @Override
    public Ticket buyTicket(Ticket ticket) {
        Flight flight = ticket.getFlight();
        if (flight.getFlightQuota() > 0) {
            calculateTicketPrice(ticket, flight.getFlightQuota());
            ticket.setEmpty(false);
            flight.setFlightQuota(flight.getFlightQuota() - 1);
            flightRepository.save(flight);

            return ticketRepository.save(ticket);
        }
        throw new RuntimeException("No more tickets");
    }

    @Override
    public Ticket cancelTicket(Ticket ticket) {
        if (!ticket.isEmpty()) {
            ticket.setEmpty(true);
            Flight flight = ticket.getFlight();
            flight.setFlightQuota(flight.getFlightQuota() + 1);
            calculateTicketAfterCancel(ticket);
            flightRepository.save(flight);
            ticketRepository.save(ticket);
            return ticket;
        }
        throw new RuntimeException("Ticket is empty");
    }
}
