package com.xworkz.hospital.runner;

import com.xworkz.hospital.entity.HospitalEntity;

import javax.persistence.*;

public class HospitalApplication {
    public static void main(String[] args) {
        HospitalEntity hospital =new HospitalEntity();
        hospital.setHospitalId(1);
        hospital.setHosp_Name("Fortis");
        hospital.setRegNo("Forstis123");
        hospital.setAddress("Shakurpur");
        hospital.setCity("Delhi");
        hospital.setState("Delhi");
        hospital.setContact("7849563210");
        hospital.setEmail("fortis@gmail.com");
        hospital.setYear(1986);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hos");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(hospital);
            System.out.println("Hospital data is saved");
            et.commit();

            HospitalEntity entity = em.find(HospitalEntity.class, 1);
            System.out.println(entity);
        }catch (PersistenceException e){
            et.rollback();
            e.printStackTrace();
        }finally {
            emf.close();
            em.close();
        }
    }
}
