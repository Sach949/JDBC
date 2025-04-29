package com.xworkz.bookmyshow.repo;

import com.xworkz.bookmyshow.entity.RegistrationEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class RegistrationRepoImpl implements RegistrationRepo {


    @Override
    public boolean saveUser(RegistrationEntity entity) {
        EntityManager manager = Persistence.createEntityManagerFactory("myProject").createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        System.out.println("Data is: " +manager);
        manager.getTransaction().commit();
        return true;
    }
}