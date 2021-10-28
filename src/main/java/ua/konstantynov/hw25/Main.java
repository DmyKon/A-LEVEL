//Please implement a database application which allows you to manage vehicles in the dealer center.
//Every vehicle must have the following properties:
//1. name
//2. owner
//3. manufacture date
//4. price
//5. tyres type
//6. service date
//System must allow to create, update, delete and get vehicles. Using the dao layer is compulsory.
package ua.konstantynov.hw25;

import ua.konstantynov.hw25.entities.Owner;
import ua.konstantynov.hw25.entities.Vehicle;
import ua.konstantynov.hw25.service.VehicleService;

import java.util.Date;

public class Main {
    public static final VehicleService VEHICLE_SERVICE = new VehicleService();

    public static void main(String[] args) {
        Owner user = new Owner("User");
        Owner admin = new Owner("Admin");
        Vehicle Aleveludi = new Vehicle("Aleveludi", admin,
                new Date(), 100_000d, "SUMMER", new Date());
        Vehicle Javesla = new Vehicle("Javesla", admin,
                new Date(), 500_000d, "WINTER", new Date());
        Vehicle HiberVagen = new Vehicle("HiberVagen", user,
                new Date(), 1000_000d, "ALL_SEASON", new Date());
        String vehicleId_1 = VEHICLE_SERVICE.save(Aleveludi);
        String vehicleId_2 = VEHICLE_SERVICE.save(Javesla);
        String vehicleId_3 = VEHICLE_SERVICE.save(HiberVagen);
        System.out.println("\nsave");
        VEHICLE_SERVICE.getAll().forEach(System.out::println);
        System.out.println("\nupdate");
        Aleveludi.setId(vehicleId_2);
        VEHICLE_SERVICE.update(Aleveludi);
        VEHICLE_SERVICE.getAll().forEach(System.out::println);
        System.out.println("\ndelete");
        VEHICLE_SERVICE.delete(vehicleId_3);
        VEHICLE_SERVICE.getAll().forEach(System.out::println);
        System.out.println("\nget");
        System.out.println(VEHICLE_SERVICE.get(vehicleId_1));
    }
}
