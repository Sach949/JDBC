package com.xworkz.res.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "RESTAURANT")
@Entity
@Data
public class RestaurantEntity {

    @Id
    @Column(name = "regId")
    private int regId;

    @Column(name = "name")
    private String name;

    @Column(name = "ownerName")
    private String owner;

    @Column(name = "location")
    private String location;

    @Column(name = "typeOfFood")
    private String typeOfFood;

    @Column(name = "gstReg")
    private String gst;

    @Column(name = "fssaiReg")
    private String fssai;

    @Column(name = "noOfEmp")
    private int noOfEmp;

    @Column(name = "avgSalary")
    private int avgSalary;
}
