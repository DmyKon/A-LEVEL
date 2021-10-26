package ua.konstantynov.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.konstantynov.hw24.objects.Device;
import ua.konstantynov.hw24.objects.DeviceDTO;
import ua.konstantynov.hw24.utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
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
            device = session.createQuery("SELECT d FROM Device d WHERE d.id = :id", Device.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }
        return device;
    }

    public void change(String id, String column, String value) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(
                    String.format("UPDATE Device d SET %s = :value WHERE d.id = :id", column))
                    .setParameter("id", id)
                    .setParameter("value", value);
            query.executeUpdate();
            transaction.commit();
        }
    }

    public List<Device> getDevicesListByFactoryId(String id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT d FROM Device d " +
                            "INNER JOIN Factory f " +
                            "ON d.factory.id = f.id AND f.id = :id", Device.class)
                    .setParameter("id", id)
                    .list();
        }
    }

    public List<DeviceDTO> getCountAndSumForEachFactory() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            List<Object[]> list = session.createQuery(
                    "SELECT d.factory.id, SUM(d.price) AS total, COUNT(d.factory.id) AS count " +
                            "FROM Device d " +
                            "GROUP BY d.factory.id", Object[].class)
                    .getResultList();
            List<DeviceDTO> resultList = new ArrayList<>();
            for (Object[] objects : list) {
                DeviceDTO deviceDTO = new DeviceDTO();
                for (Object object : objects) {
                    if (object instanceof String) {
                        deviceDTO.setFactoryId((String) object);
                    }
                    if (object instanceof Double) {
                        deviceDTO.setTotal((Double) object);
                    }
                    if (object instanceof Long) {
                        deviceDTO.setCount((Long) object);
                    }
                }
                resultList.add(deviceDTO);
            }
            return resultList;
        }
    }

    public List<Device> getAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT d FROM Device d", Device.class)
                    .list();
        }
    }

    public void delete(String id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(
                    "DELETE FROM Device d WHERE d.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }
}
