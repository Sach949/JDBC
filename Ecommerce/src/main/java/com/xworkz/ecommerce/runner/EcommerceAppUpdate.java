package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.ProductEntity;

import javax.persistence.*;

public class EcommerceAppUpdate {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            ProductEntity entity = em.find(ProductEntity.class, 103);
            System.out.println("data is: " +entity);
            if(entity != null){
                entity.setCategory("Milton");
                entity.setPrice(2500);
                entity.setQtyAvailable("No");
              ProductEntity updatedEntity= em.merge(entity);
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
