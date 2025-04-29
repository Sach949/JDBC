package com.xworkz.event.runner;

import com.xworkz.event.entity.EventRegEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

public class EventMgmtApplication {
    public static void main(String[] args) {

        EventRegEntity entity = new EventRegEntity();
        entity.setRegId(1);
        entity.setName("Rahul");
        entity.setParentName("Mehul");
        entity.setDateOfBirth(LocalDate.of(2000,04,12));
        entity.setAge(25);
        entity.setGender("Male");
        entity.setMobileNo(7845963210l);
        entity.setEmail("rahul@gmail.com");
        entity.setAddress("25, ABC road. Bengaluru");
        entity.setRegAmount(45216.25);
        entity.setPaymentMethod("Online");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("event-mgmt");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
       try {
           et.begin();
           em.persist(entity);
           System.out.println("Data is saved");
           et.commit();

           //
//           EventRegEntity regEntity = em.find(EventRegEntity.class,1);
//           System.out.println(regEntity);
       }catch (PersistenceException e){
           et.rollback();
           e.printStackTrace();
       }finally {
            emf.close();
            em.close();
       }


    }
}
