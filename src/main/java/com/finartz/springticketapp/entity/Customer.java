package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class Customer extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String mobilePhone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}
