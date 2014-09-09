package com.realdolmen.course;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceTest {

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @BeforeClass
    public static void initializeEntityManagerFactor(){
        entityManagerFactory = Persistence.createEntityManagerFactory("KerisPu");
    }

    @Before
    public void initialize(){
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }
    @After
    public void destroy(){
        if(transaction !=null && !transaction.getRollbackOnly()){
            transaction.commit();
        }
        if(entityManager!=null){
            entityManager.close();
        }
    }
    @AfterClass
    public static void destroyEntityManagerFactory(){
        if(entityManagerFactory!=null){
            entityManagerFactory.close();
        }
    }
    protected EntityManager entityManager(){
        return this.entityManager;
    }
}
