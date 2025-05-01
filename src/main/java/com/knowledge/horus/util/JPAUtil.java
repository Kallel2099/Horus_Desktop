package com.knowledge.horus.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private final EntityManagerFactory factory;
    private static JPAUtil instance;

    private JPAUtil() {
        // Inicia a conexão com o banco conforme configurado no persistence.xml
        this.factory = Persistence.createEntityManagerFactory("horusdb");
    }

    // Garante uma única instancia da conexão com o banco
    public static synchronized JPAUtil getInstance() {
        if (instance == null) {
            instance = new JPAUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}