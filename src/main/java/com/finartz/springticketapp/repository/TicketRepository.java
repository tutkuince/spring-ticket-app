package com.finartz.springticketapp.repository;

import com.finartz.springticketapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
