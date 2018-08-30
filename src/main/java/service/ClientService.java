package service;

import domain.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Objects;

public class ClientService {
    private static final ThreadLocal<EntityManager> THREAD_LOCAL = new ThreadLocal<>();

    public EntityManager getEntityManager() {
        if (Objects.isNull(THREAD_LOCAL.get())) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("healthy");

            EntityManager em = factory.createEntityManager();

            THREAD_LOCAL.set(em);
        }

        return THREAD_LOCAL.get();
    }

    public void save(Client client){
        EntityManager em = getEntityManager();

        EntityTransaction tran = em.getTransaction();

        tran.begin();

        em.persist(client);

        tran.commit();
    }
}
