package com.xworkz.bookmyshow.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationDto {

    private int regId;
    private  String name;
    private LocalDate dob;
    private long mobileNo;
    private String email;
    private String country;
    private LocalDate reg_Date;
}
