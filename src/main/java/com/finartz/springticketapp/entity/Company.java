package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Company extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private String airlineCode;

    private String description;

    @NotNull
    private String contactNumber;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn
    private Airport airport;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Flight> flights;
}
