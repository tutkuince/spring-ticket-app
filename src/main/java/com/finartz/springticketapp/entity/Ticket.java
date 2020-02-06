package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
public class Ticket extends BaseEntity {

    private BigDecimal price;
    private int gate;
    private String seat;
    private String ticketNumber;

}
