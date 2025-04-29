package com.xworkz.event.runner;

import com.xworkz.event.entity.EventRegEntity;

import javax.persistence.*;

public class EventUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("event-mgmt");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            EventRegEntity entity = em.find(EventRegEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                entity.setParentName("Mahesh Rao");
                entity.setAddress("10 Janpath Delhi");
                entity.setPaymentMethod("Cash");
                EventRegEntity updatedEntity= em.merge(entity);
                System.out.println("updated data is: "+updatedEntity);
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
