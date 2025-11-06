package com.knightsanddie;

import com.knightsanddie.model.Knight;
import com.knightsanddie.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnightHibernateTest {

    @AfterAll
    static void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    public void persistAndRetrieveKnight() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

    Knight k = new Knight("Lancelot");
    // Use persist instead of save and avoid relying on JDBC generated keys
    session.persist(k);

    tx.commit();
    session.close();

    Session session2 = HibernateUtil.getSessionFactory().openSession();
    Knight loaded = session2.createQuery("from Knight where name = :n", Knight.class)
        .setParameter("n", "Lancelot")
        .setMaxResults(1)
        .uniqueResult();
    session2.close();

    Assertions.assertNotNull(loaded, "Expected to find the saved Knight by name");
    Assertions.assertEquals("Lancelot", loaded.getName());
    }
}
