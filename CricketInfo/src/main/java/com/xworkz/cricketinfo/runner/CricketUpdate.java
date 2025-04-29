package com.xworkz.cricketinfo.runner;

import com.xworkz.cricketinfo.entity.CricketEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CricketUpdate {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cricket");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            CricketEntity entity = em.find(CricketEntity.class, 1);
            System.out.println("data is: " +entity);
            if(entity != null){
                entity.setDob(LocalDate.of(2000,11,23));
                entity.setDomRun(15000);
                entity.setOdiAvg(54.25);
                entity.setPlayerName("Karun Nair");
                entity.setIplTeam("Delhi");
                CricketEntity updatedEntity= em.merge(entity);
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
