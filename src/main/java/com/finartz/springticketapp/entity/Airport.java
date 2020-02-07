package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class Airport extends BaseEntity {

    @NotNull
    private String name;
    private String description;

    @NotNull
    private String address;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private Set<Company> companies;
}
