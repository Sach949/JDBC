package com.xworkz.ecommerce.repository;

import com.xworkz.ecommerce.entity.ProductEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ProductRepoImpl implements ProductRepo {

    @Override
    public void saveProduct(ProductEntity entity) {
        EntityManager manager =  Persistence.createEntityManagerFactory("x-workz")
                .createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
    }
}
