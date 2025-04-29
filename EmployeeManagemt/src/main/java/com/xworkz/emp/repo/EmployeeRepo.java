package com.xworkz.emp.repo;

import com.xworkz.emp.entity.EmpMastEntity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepo {

    void saveEmployeeData(EmpMastEntity entity);

    void updatedData(EmpMastEntity entity);

    EmpMastEntity getEmployee(String empData);

    List<String> getName();

    LocalDate getJoinDate(int id);

    boolean updateJoinDateDesigAddressById(LocalDate joinDate, String desig, String address2, int empId);

    boolean deleteData(int id);

    List<Object> getDesignation();

    List<Object[]> getNameDesignation();

    List<Object> getNameId();

    List<Object> getNameMobileEmail();

    List<Object> getNameDobJoiDate();
}
