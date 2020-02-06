package com.finartz.springticketapp.entity;

import com.finartz.springticketapp.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Customer extends BaseEntity {

    private String name;
    private String surname;
    private String mobilePhone;
}
