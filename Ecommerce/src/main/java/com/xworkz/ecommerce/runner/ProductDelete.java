package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.ProductEntity;

import javax.persistence.*;

public class ProductDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            ProductEntity entity = em.find(ProductEntity.class, 101);
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
