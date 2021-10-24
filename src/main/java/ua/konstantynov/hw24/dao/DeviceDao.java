package ua.konstantynov.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.konstantynov.hw24.objects.Device;
import ua.konstantynov.hw24.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class DeviceDao {
    public void save(Device device) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(device);
            transaction.commit();
        }
    }

    public Device getById(String id) {
        Device device;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            device = session.createQuery("SELECT d FROM device d WHERE d.device_id = :id",
                    Device.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }
        return device;
    }

    public List<Device> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT d FROM device d", Device.class
            ).list();
        }
    }

    public void deleteById(String id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(
                    "DELETE FROM Horse h WHERE h.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }
}
