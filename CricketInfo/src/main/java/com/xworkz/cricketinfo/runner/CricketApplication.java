package com.xworkz.cricketinfo.runner;

import com.xworkz.cricketinfo.entity.CricketEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CricketApplication {

    public static void main(String[] args) {

        CricketEntity cricket = new CricketEntity();
        cricket.setPlayerId(1);
        cricket.setPlayerName("Rohit");
        cricket.setDob(LocalDate.now());
        cricket.setJerseyNo(45);
        cricket.setCountry("India");
        cricket.setIplTeam("Mumbai");
        cricket.setIntRun(11000);
        cricket.setDomRun(8900);
        cricket.setOdiAvg(49.52);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cricket");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(cricket);
            System.out.println("Cricket data is saved");
            et.commit();

            CricketEntity entity = em.find(CricketEntity.class, 1);
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
