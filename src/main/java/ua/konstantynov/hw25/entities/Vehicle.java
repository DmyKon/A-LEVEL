package ua.konstantynov.hw25.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "vehicle_id")
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "manufacture_date")
    private Date manufactureDate;

    @Column(name = "price")
    private Double price;

    @Column(name = "tyres_type")
    private String tyresType;

    @Column(name = "service_date")
    private Date serviceDate;

    public Vehicle(String name, Owner owner, Date manufactureDate, Double price,
                   String tyresType, Date serviceDate) {
        this.name = name;
        this.owner = owner;
        this.manufactureDate = manufactureDate;
        this.price = price;
        this.tyresType = tyresType;
        this.serviceDate = serviceDate;
    }
}