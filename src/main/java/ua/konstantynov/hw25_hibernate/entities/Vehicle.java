package ua.konstantynov.hw25_hibernate.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode
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
    private LocalDate manufactureDate;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "tyres_type")
    private TyresType tyresType;

    @Column(name = "service_date")
    private LocalDate serviceDate;

    public Vehicle(String name, Owner owner, LocalDate manufactureDate, Double price,
                   TyresType tyresType, LocalDate serviceDate) {
        this.name = name;
        this.owner = owner;
        this.manufactureDate = manufactureDate;
        this.price = price;
        this.tyresType = tyresType;
        this.serviceDate = serviceDate;
    }
}