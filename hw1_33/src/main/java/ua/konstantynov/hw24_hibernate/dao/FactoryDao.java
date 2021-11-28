package ua.konstantynov.hw24_hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.konstantynov.hw24_hibernate.objects.Factory;
import ua.konstantynov.hw24_hibernate.utils.HibernateSessionFactoryUtil;

public class FactoryDao {
    public void save(Factory factory) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(factory);
            transaction.commit();
        }
    }

    public Factory getById(String id) {
        Factory factory;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            factory = session.createQuery("SELECT f FROM Factory f WHERE f.id = :id", Factory.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }
        return factory;
    }
}
