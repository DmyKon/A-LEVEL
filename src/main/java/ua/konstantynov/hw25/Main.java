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

import ua.konstantynov.hw25.entities.Vehicle;
import ua.konstantynov.hw25.service.VehicleService;

import java.util.Date;
import java.util.UUID;

public class Main {
    public static final VehicleService vehicleService = new VehicleService();

    public static void main(String[] args) {
        Vehicle vehicle_1 = new Vehicle("Aleveludi", UUID.randomUUID().toString(),
                new Date(), 100_000d, "SUMMER", new Date());
        Vehicle vehicle_2 = new Vehicle("Javesla", UUID.randomUUID().toString(),
                new Date(), 500_000d, "WINTER", new Date());
        Vehicle vehicle_3 = new Vehicle("HiberVagen", UUID.randomUUID().toString(),
                new Date(), 1000_000d, "ALL_SEASON", new Date());
        String vehicleId_1 = vehicleService.save(vehicle_1);
        String vehicleId_2 = vehicleService.save(vehicle_2);
        String vehicleId_3 = vehicleService.save(vehicle_3);
        System.out.println("\nsave");
        vehicleService.getAll().forEach(System.out::println);
        System.out.println("\nupdate");
        vehicle_1.setId(vehicleId_2);
        vehicleService.update(vehicle_1);
        vehicleService.getAll().forEach(System.out::println);
        System.out.println("\ndelete");
        vehicleService.delete(vehicleId_3);
        vehicleService.getAll().forEach(System.out::println);
        System.out.println("\nget");
        System.out.println(vehicleService.get(vehicleId_1));
    }
}
