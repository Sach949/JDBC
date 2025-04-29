package com.xworkz.emp.service;

import com.xworkz.emp.entity.EmpMastEntity;
import com.xworkz.emp.repo.EmployeeRepo;
import com.xworkz.emp.repo.EmployeeRepoImpl;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepo repo = new EmployeeRepoImpl();

    @Override
    public void saveEmpData(EmpMastEntity entity) {
        repo.saveEmployeeData(entity);
    }

    @Override
    public void updatedData(EmpMastEntity entity) {
        repo.updatedData(entity);
    }

    @Override
    public EmpMastEntity getEmployee(String empData) {
        return repo.getEmployee(empData);
    }

    @Override
    public List<String> getName() {
        return repo.getName();
    }

    @Override
    public LocalDate getJoinDate(int id) {
        return repo.getJoinDate(id);
    }

    @Override
    public boolean updateJoinDateDesigAddressById(LocalDate joinDate, String desig, String address2, int empId) {
        return repo.updateJoinDateDesigAddressById(joinDate,desig,address2,empId);
    }

    @Override
    public boolean deleteData(int id) {
        return repo.deleteData(id);
    }

    @Override
    public List<Object> getDesignation() {
        return repo.getDesignation();
    }

    @Override
    public List<Object[]> getNameDesignation() {
        return repo.getNameDesignation();
    }

    @Override
    public List<Object> getNameId() {
        return repo.getNameId();
    }

    @Override
    public List<Object> getNameMobileEmail() {
        return repo.getNameMobileEmail();
    }

    @Override
    public List<Object> getNameDobJoiDate() {
        return repo.getNameDobJoiDate();
    }
}
