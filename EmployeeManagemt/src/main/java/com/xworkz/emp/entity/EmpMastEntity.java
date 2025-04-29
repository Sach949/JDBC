package com.xworkz.emp.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "employee")
@NamedQuery(name = "getEmpByAddress", query = "select e from EmpMastEntity e where e.addr1 = :addr")
@NamedQuery(name = "getEmpName", query="select e.name from EmpMastEntity e")
@NamedQuery(name = "getJoinDate", query = "select e.date_of_joining from EmpMastEntity e where e.empId = :eid")
@NamedQuery(name = "updateJoinDateDesigAddressById", query ="update EmpMastEntity e set e.date_of_joining=:join, " +
        "e.desig=:deg, e.addr2=:addr where e.empId=:eid")
@NamedQuery(name = "deleteData", query ="Delete From EmpMastEntity e where e.empId=:eid")
@NamedQuery(name = "getDesignation",query = "select e.desig from EmpMastEntity e ")
@NamedQuery(name="getNameDesignation", query = "select e.name, e.desig from EmpMastEntity e")
@NamedQuery(name="getNameId", query = "select e.name, e.idCard from EmpMastEntity e")
@NamedQuery(name="getNameMobileEmail", query = "select e.name, e.mobile, e.email from EmpMastEntity e")
@NamedQuery(name="getNameDobJoiDate", query = "select e.name, e.dob, e.date_of_joining from EmpMastEntity e")
@Entity
@Data
public class EmpMastEntity {

    @Id
    @Column(name = "empid")
    private int empId;

    @Column(name = "name")
    private String name;

    @Column(name = "designation")
    private String desig;

    @Column(name = "idCard")
    private String idCard;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "dateOfJoining")
    private LocalDate date_of_joining;

    @Column(name = "address1")
    private String addr1;

    @Column(name = "address2")
    private String addr2;

    @Column(name = "mobile")
    private long mobile;

    @Column(name = "emailId")
    private String email;

    @Column(name = "sysDate")
    private LocalDate sysDate;

}
