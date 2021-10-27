package ua.konstantynov.hw25.service;

import ua.konstantynov.hw25.dao.VehicleDao;
import ua.konstantynov.hw25.entities.Vehicle;

import java.util.List;

public class VehicleService {
    private static final VehicleDao VEHICLE_DAO = new VehicleDao();

    public String save(Vehicle vehicle) {
        VEHICLE_DAO.save(vehicle);
        return vehicle.getId();
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
