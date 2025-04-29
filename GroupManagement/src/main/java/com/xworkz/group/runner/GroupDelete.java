package com.xworkz.group.runner;

import com.xworkz.group.entity.GroupEntity;

import javax.persistence.*;

public class GroupDelete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("group");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            GroupEntity entity = em.find(GroupEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                em.remove(entity);
                System.out.println(" data is deleted: ");
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
