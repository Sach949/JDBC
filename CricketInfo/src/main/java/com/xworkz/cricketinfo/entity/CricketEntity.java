package com.xworkz.cricketinfo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Table(name = "CRICKET_INFO")
@Entity
@Data
public class CricketEntity {

    @Id
    @Column(name = "playerId")
    private int playerId;

    @Column(name = "playerName")
    private String playerName;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "jerseyNo")
    private int jerseyNo;

    @Column(name = "country")
    private String country;

    @Column(name = "ipl_team")
    private String iplTeam;

    @Column(name = "internationalRun")
    private int intRun;

    @Column(name = "domesticRun")
    private int domRun;

    @Column(name = "odi_avg")
    private double odiAvg;
}
