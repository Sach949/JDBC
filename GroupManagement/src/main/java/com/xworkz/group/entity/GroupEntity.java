package com.xworkz.group.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Table(name = "group_info")
@Entity
@Data
public class GroupEntity {

    @Id
    @Column(name = "group_id")
    private int groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "description")
    private String description;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDate createDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_members")
    private  int totalMember;

    @Column(name = "group_type")
    private  String groupType;

    @Column(name = "last_updated_date")
    private LocalDate last_updated_date;

}
