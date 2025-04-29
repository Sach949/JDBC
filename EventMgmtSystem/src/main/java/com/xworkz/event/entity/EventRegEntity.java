package com.xworkz.event.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "event_mgmt")
@Entity
@Data
public class EventRegEntity {

    @Id
    @Column(name = "REG_ID")
    private int regId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PARENT_NAME")
    private String parentName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "MOBILE_NO")
    private long mobileNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "REG_AMOUNT")
    private double regAmount;

    @Column(name = "PAYMENT_METHOD")
    private String paymentMethod;
}
