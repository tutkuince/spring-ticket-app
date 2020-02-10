package com.finartz.springticketapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ticket extends BaseEntity {

    @NotNull
    private BigDecimal price;

    @NotNull
    private int gate;

    @NotNull
    private String seat;

    private String ticketNumber;

    private boolean isEmpty;

    public Ticket() {
        this.isEmpty = true;
        UUID uuid = UUID.randomUUID();
        this.ticketNumber = uuid.toString();
    }

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn
    private Flight flight;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn
    private Customer customer;
}
