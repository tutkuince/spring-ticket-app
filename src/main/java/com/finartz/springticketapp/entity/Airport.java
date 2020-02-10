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
public class Airport extends BaseEntity {

    @NotNull
    private String name;
    private String description;

    @NotNull
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "airport_company",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> companies;
}
