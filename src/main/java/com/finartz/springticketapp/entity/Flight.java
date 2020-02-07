package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Flight extends BaseEntity {

    @NotNull
    private LocalDateTime time;

    @NotNull
    private int flightQuota;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn
    private Route route;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn
    private Company company;
}
