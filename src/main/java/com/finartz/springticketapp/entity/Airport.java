package com.finartz.springticketapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private Set<Company> companies;
}
