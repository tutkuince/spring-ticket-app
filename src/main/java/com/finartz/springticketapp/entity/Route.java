package com.finartz.springticketapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Route extends BaseEntity {

    @NotNull
    private String flightFrom;

    @NotNull
    private String flightTo;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private Set<Flight> flights;
}
