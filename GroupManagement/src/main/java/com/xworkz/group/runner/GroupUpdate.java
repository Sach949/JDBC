package com.xworkz.group.runner;

import com.xworkz.group.entity.GroupEntity;

import javax.persistence.*;

public class GroupUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("group");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            GroupEntity entity = em.find(GroupEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                entity.setGroupName("Developers");
                entity.setGroupType("Project");
                entity.setStatus("Inactive");
                GroupEntity updatedpGroup= em.merge(entity);
                System.out.println("updated data is: "+updatedpGroup);
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
