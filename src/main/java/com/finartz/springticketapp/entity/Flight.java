package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Data
public class Flight extends BaseEntity {

    private String from;
    private String to;
    private LocalDateTime departureDate;
}
