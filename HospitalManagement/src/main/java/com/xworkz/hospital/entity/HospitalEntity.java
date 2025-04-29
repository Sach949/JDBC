package com.xworkz.hospital.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "hospital_info")
@Entity
@Data
public class HospitalEntity {

    @Id
    @Column(name = "hospital_id")
    private int hospitalId;

    @Column(name = "hospital_name")
    private String hosp_Name;

    @Column(name = "registration_no")
    private String regNo;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "contact_number")
    private String contact;

    @Column(name = "email")
    private String email;

    @Column(name = "established_year")
    private int year;

}
