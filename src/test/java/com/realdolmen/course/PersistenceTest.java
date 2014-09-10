package com.realdolmen.course;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceTest {

    private static final Logger logger = LoggerFactory.getLogger(PersistenceTest.class);

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    @BeforeClass
    public static void initializeEntityManagerFactor(){
        logger.info("Creating EntityManagerFactory");
        entityManagerFactory = Persistence.createEntityManagerFactory("KerisPu");
    }

    @Before
    public void initialize(){
        logger.info("Creating transacted EntityManager");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
        transaction.begin();
    }
    @After
    public void destroy(){
        logger.info("Committing and closing transacted EntityManager");
        if(transaction !=null && !transaction.getRollbackOnly()){
            transaction.commit();
        }
        if(entityManager!=null){
            entityManager.close();
        }
    }
    @AfterClass
    public static void destroyEntityManagerFactory(){
        logger.info("Closing entityManagerFactory");
        if(entityManagerFactory!=null){
            entityManagerFactory.close();
        }
    }
    protected EntityManager entityManager(){
        return this.entityManager;
    }
}
