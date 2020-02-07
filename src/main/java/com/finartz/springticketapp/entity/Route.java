package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Route extends BaseEntity {

    @NotNull
    private String flightFrom;

    @NotNull
    private String flightTo;

    @NotNull
    private LocalDate departureDate;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private Set<Flight> flights;
}
