package ua.konstantynov.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.konstantynov.hw24.objects.Factory;
import ua.konstantynov.hw24.utils.HibernateSessionFactoryUtil;

public class FactoryDao {
    public void save(Factory factory) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(factory);
            transaction.commit();
        }
    }
}
