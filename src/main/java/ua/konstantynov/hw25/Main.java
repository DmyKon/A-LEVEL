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
import ua.konstantynov.hw25.entities.TyresType;
import ua.konstantynov.hw25.entities.Vehicle;
import ua.konstantynov.hw25.service.VehicleService;

import java.time.LocalDate;

public class Main {
    public static final VehicleService VEHICLE_SERVICE = new VehicleService();

    public static void main(String[] args) {
        Owner user = new Owner("User");
        Owner admin = new Owner("Admin");
        Vehicle aleveludi = new Vehicle("Aleveludi", admin, LocalDate.of(2000, 1, 1),
                100_000d, TyresType.SUMMER, LocalDate.now());
        Vehicle javesla = new Vehicle("Javesla", admin, LocalDate.of(2005, 5, 5),
                500_000d, TyresType.WINTER, LocalDate.now());
        Vehicle hiberVagen = new Vehicle("HiberVagen", user, LocalDate.of(2020, 10, 10),
                1000_000d, TyresType.ALL_SEASON, LocalDate.now()
        );
        VEHICLE_SERVICE.save(aleveludi);
        VEHICLE_SERVICE.save(javesla);
        VEHICLE_SERVICE.save(hiberVagen);
        System.out.println("\nsave");
        VEHICLE_SERVICE.getAll().forEach(System.out::println);
        System.out.println("\nupdate");
        aleveludi.setName("TEST TEST TEST");
        VEHICLE_SERVICE.update(aleveludi);
        VEHICLE_SERVICE.getAll().forEach(System.out::println);
        System.out.println("\ndelete");
        VEHICLE_SERVICE.delete(hiberVagen.getId());
        VEHICLE_SERVICE.getAll().forEach(System.out::println);
        System.out.println("\nget");
        System.out.println(VEHICLE_SERVICE.get(aleveludi.getId()));
    }
}
