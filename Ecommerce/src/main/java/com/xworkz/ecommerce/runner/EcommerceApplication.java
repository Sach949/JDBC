package com.xworkz.ecommerce.runner;

import com.xworkz.ecommerce.entity.ProductEntity;

import javax.persistence.*;

public class EcommerceApplication {
    public static void main(String[] args) {

        ProductEntity product = new ProductEntity();
        product.setProductId(103);
        product.setProductName("Gas Stove");
        product.setDescription("Pigeon");
        product.setCategory("Kitchen");
        product.setPrice(1600);
        product.setQtyAvailable("Yes");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");//to get connection
        EntityManager em = emf.createEntityManager();//to insert, update, delete, select - persit();
        EntityTransaction et = em.getTransaction();//to save, commit, rollback (begin(), commit(), rollback())
        try {
            //
           et.begin();//autocommit = 0
           em.persist(product);
            System.out.println("Data is saved");
           et.commit();
            ProductEntity entity = em.find(ProductEntity.class,101);
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
