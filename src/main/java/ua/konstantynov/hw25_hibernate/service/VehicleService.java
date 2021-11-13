package ua.konstantynov.hw25_hibernate.service;

import ua.konstantynov.hw25_hibernate.dao.VehicleDao;
import ua.konstantynov.hw25_hibernate.entities.Vehicle;

import java.util.List;

public class VehicleService {
    private static final VehicleDao VEHICLE_DAO = new VehicleDao();

    public void save(Vehicle vehicle) {
        VEHICLE_DAO.save(vehicle);
    }

    public void update(Vehicle vehicle) {
        VEHICLE_DAO.update(vehicle);
    }

    public void delete(String id) {
        VEHICLE_DAO.delete(id);
    }

    public Vehicle get(String id) {
        return VEHICLE_DAO.get(id);
    }

    public List<Vehicle> getAll() {
        return VEHICLE_DAO.getAll();
    }
}
