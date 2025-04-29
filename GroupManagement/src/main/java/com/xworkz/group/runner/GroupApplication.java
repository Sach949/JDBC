package com.xworkz.group.runner;

import com.xworkz.group.entity.GroupEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

public class GroupApplication {
    public static void main(String[] args) {
        GroupEntity group = new GroupEntity();
        group.setGroupId(1);
        group.setGroupName("Geeks");
        group.setDescription("Hello");
        group.setCreatedBy("Ashok");
        group.setCreateDate(LocalDate.now());
        group.setStatus("Active");
        group.setTotalMember(23);
        group.setGroupType("Office");
        group.setLast_updated_date(LocalDate.now());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("group");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(group);
            System.out.println("Hospital data is saved");
            et.commit();

            GroupEntity entity = em.find(GroupEntity.class, 1);
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
