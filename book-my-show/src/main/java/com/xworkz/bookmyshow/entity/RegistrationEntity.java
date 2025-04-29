package com.xworkz.bookmyshow.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQuery(name = "saveUser", query = "")
@Table(name = "REGISTRATION")
@Entity
@Data
public class RegistrationEntity {

    @Id
    @Column(name = "REG_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regId;

    @Column(name = "USER_NAME")
    private  String name;

    @Column(name = "DOB")
    private LocalDate dob;

    @Column(name = "MOBILE_NO")
    private long mobileNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "REG_DATE")
    private LocalDate reg_Date;

}

