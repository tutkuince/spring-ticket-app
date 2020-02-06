package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Company extends BaseEntity {

    private String name;
    private String airlineCode;
    private String description;
    private String contactNumber;
}
