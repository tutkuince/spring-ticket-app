package com.finartz.springticketapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private String airlineCode;

    private String description;

    @NotNull
    private String contactNumber;

    @ManyToMany(mappedBy = "companies")
    private Set<Airport> airports;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Flight> flights;
}
