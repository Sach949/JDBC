package com.xworkz.emp.repo;

import com.xworkz.emp.entity.EmpMastEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EmployeeRepoImpl implements EmployeeRepo {


    @Override
    public void saveEmployeeData(EmpMastEntity entity) {
       EntityManager manager = Persistence.createEntityManagerFactory("emp").createEntityManager();
       manager.getTransaction().begin();
       manager.persist(entity);
        System.out.println("Data is: " +manager);
       manager.getTransaction().commit();
    }

    @Override
    public void updatedData(EmpMastEntity entity) {
        EntityManager manager = Persistence.createEntityManagerFactory("emp").createEntityManager();
        manager.getTransaction().begin();
        EmpMastEntity empMast = manager.find(EmpMastEntity.class,102);
        if(empMast!=null){
            //EmpMastEntity mastEntity=manager.merge(empMast.getMobile());
        }else{
            System.out.println("No data is found");
        }
    }

    @Override
    public EmpMastEntity getEmployee(String empData) {
        Query query = Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getEmpByAddress");
        query.setParameter("addr",empData);
        EmpMastEntity empMast = (EmpMastEntity) query.getSingleResult();
        System.out.println(empMast);
        return null;
    }

    @Override
    public List<String> getName() {
        return Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getEmpName").getResultList();
    }

    @Override
    public LocalDate getJoinDate(int id) {
        return (LocalDate) Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getJoinDate").setParameter("eid",id).getSingleResult();
    }

    @Override
    public boolean updateJoinDateDesigAddressById(LocalDate joinDate, String desig, String address2, int empId) {
        EntityManager manager =  Persistence.createEntityManagerFactory("emp").createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNamedQuery("updateJoinDateDesigAddressById");
        query.setParameter("join", joinDate);
        query.setParameter("deg", desig);
        query.setParameter("addr", address2);
        query.setParameter("eid", empId);
        query.executeUpdate();
        manager.getTransaction().commit();

        return false;
    }

    @Override
    public boolean deleteData(int id) {
        EntityManager manager =  Persistence.createEntityManagerFactory("emp").createEntityManager();
        manager.getTransaction().begin();
        Query query = manager.createNamedQuery("deleteData");
        manager.remove(query);
        manager.getTransaction().commit();
        return false;
    }

    @Override
    public List<Object> getDesignation() {
        return Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getDesignation").getResultList();
    }

    @Override
    public List<Object[]> getNameDesignation() {
        return Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getNameDesignation").getResultList();
    }

    @Override
    public List<Object> getNameId() {
        return Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getNameId").getResultList();
    }

    @Override
    public List<Object> getNameMobileEmail() {
        return Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getNameMobileEmail").getResultList();
    }

    @Override
    public List<Object> getNameDobJoiDate() {
        return Persistence.createEntityManagerFactory("emp").createEntityManager()
                .createNamedQuery("getNameDobJoiDate").getResultList();
    }

}
