package com.xworkz.res.runner;

import com.xworkz.res.entity.RestaurantEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class RestaurantUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("res");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            RestaurantEntity entity = em.find(RestaurantEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                entity.setLocation("Pune");
                entity.setName("Mother's Meal");
                entity.setAvgSalary(20000);
                RestaurantEntity updatedRes= em.merge(entity);
                System.out.println("updated data is: "+updatedRes);
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
