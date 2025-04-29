package com.xworkz.res.runner;

import com.xworkz.res.entity.RestaurantEntity;

import javax.persistence.*;

public class RestaurantApplication {

    public static void main(String[] args) {
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setRegId(1);
        restaurant.setName("Vaishavi");
        restaurant.setOwner("Ramalingam");
        restaurant.setLocation("Bengaluru");
        restaurant.setTypeOfFood("Veg only");
        restaurant.setGst("123VHSNA678");
        restaurant.setFssai("YES");
        restaurant.setNoOfEmp(50);
        restaurant.setAvgSalary(15000);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("res");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(restaurant);
            System.out.println("Data is saved");
            et.commit();

            //read
            RestaurantEntity entity = em.find(RestaurantEntity.class, 1);
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
