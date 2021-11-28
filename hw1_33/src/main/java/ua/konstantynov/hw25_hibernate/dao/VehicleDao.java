package ua.konstantynov.hw25_hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.konstantynov.hw25_hibernate.entities.Vehicle;
import ua.konstantynov.hw25_hibernate.utils.HibernateUtils;

import java.util.List;

public class VehicleDao {
    public void save(Vehicle vehicle) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(vehicle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Vehicle vehicle) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(vehicle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Vehicle vehicle = session.get(Vehicle.class, id);
            if (vehicle != null) {
                session.delete(vehicle);
                System.out.println("vehicle is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Vehicle get(String id) {
        Transaction transaction = null;
        Vehicle vehicle = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            vehicle = session.get(Vehicle.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vehicle;
    }

    public List<Vehicle> getAll() {
        Transaction transaction = null;
        List<Vehicle> vehicles = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            vehicles = session.createQuery(
                    "SELECT v FROM Vehicle v", Vehicle.class)
                    .list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return vehicles;
    }
}