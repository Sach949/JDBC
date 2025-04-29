package com.xworkz.hospital.runner;

import com.xworkz.hospital.entity.HospitalEntity;

import javax.persistence.*;

public class HospitalUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hos");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            HospitalEntity entity = em.find(HospitalEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                entity.setHosp_Name("Apollo");
                entity.setRegNo("APOLLO2025");
                entity.setCity("Chennai");
                HospitalEntity updatedHosp= em.merge(entity);
                System.out.println("updated data is: "+updatedHosp);
                et.commit();
            }else{
                System.out.println("No data");
            }
        }catch (PersistenceException e){
            et.rollback();
            e.printStackTrace();
        }finally {
            emf.close();
            em.close();
        }
    }
}
