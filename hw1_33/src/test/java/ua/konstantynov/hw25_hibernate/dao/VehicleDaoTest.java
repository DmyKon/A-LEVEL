package ua.konstantynov.hw25_hibernate.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.konstantynov.hw25_hibernate.entities.Owner;
import ua.konstantynov.hw25_hibernate.entities.TyresType;
import ua.konstantynov.hw25_hibernate.entities.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class VehicleDaoTest {
    private static VehicleDao VEHICLE_DAO;
    Vehicle aleveludi;
    Vehicle javesla;
    Vehicle hiberVagen;
    Owner user;
    Owner admin;

    @BeforeAll
    static void beforeAll() {
        VEHICLE_DAO = new VehicleDao();
    }

    @BeforeEach
    void setUp() {
        user = new Owner("User");
        admin = new Owner("Admin");
        aleveludi = new Vehicle("Aleveludi", admin, LocalDate.of(2000, 1, 1),
                100_000d, TyresType.SUMMER, LocalDate.now());
        javesla = new Vehicle("Javesla", admin, LocalDate.of(2005, 5, 5),
                500_000d, TyresType.WINTER, LocalDate.now());
        hiberVagen = new Vehicle("HiberVagen", user,
                LocalDate.of(2020, 10, 10),
                1000_000d, TyresType.ALL_SEASON, LocalDate.now());
    }

    @Test
    void save() {
        VEHICLE_DAO.save(aleveludi);
        Assertions.assertEquals(aleveludi, VEHICLE_DAO.get(aleveludi.getId()));
    }

    @Test
    void update() {
        VEHICLE_DAO.save(aleveludi);
        aleveludi.setName("TEST TEST TEST");
        VEHICLE_DAO.update(aleveludi);
        Assertions.assertEquals("TEST TEST TEST", VEHICLE_DAO.get(aleveludi.getId()).getName());
    }

    @Test
    void delete() {
        VEHICLE_DAO.save(aleveludi);
        VEHICLE_DAO.delete(aleveludi.getId());
        Assertions.assertEquals(0, VEHICLE_DAO.getAll().size());
    }

    @Test
    void get() {
        VEHICLE_DAO.save(aleveludi);
        Assertions.assertEquals(aleveludi, VEHICLE_DAO.get(aleveludi.getId()));
    }

    @Test
    void getAll() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(aleveludi);
        vehicleList.add(javesla);
        vehicleList.add(hiberVagen);
        VEHICLE_DAO.save(aleveludi);
        VEHICLE_DAO.save(javesla);
        VEHICLE_DAO.save(hiberVagen);
        Assertions.assertEquals(vehicleList, VEHICLE_DAO.getAll());
    }
}