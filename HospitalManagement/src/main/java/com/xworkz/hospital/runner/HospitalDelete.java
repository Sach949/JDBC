package com.xworkz.hospital.runner;

import com.xworkz.hospital.entity.HospitalEntity;

import javax.persistence.*;

public class HospitalDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hos");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            HospitalEntity entity = em.find(HospitalEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                em.remove(entity);
                System.out.println("Data is deleted");
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
