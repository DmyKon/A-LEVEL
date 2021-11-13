package ua.konstantynov.hw24_hibernate.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "device_id", columnDefinition = "varchar(36)")
    private String id;
    private String type;

    @Column(name = "model")
    private String deviceModel;
    private Double price;

    @Column(name = "date")
    private Date creationDate;
    private String description;

    @Column(name = "in_stock")
    private boolean isInStock;

    @ManyToOne
    @JoinColumn(name = "factory_identifier")
    private Factory factory;

    public Device(String type, String deviceModel, Double price, Date creationDate,
                  String description, boolean isInStock, Factory factory) {
        this.type = type;
        this.deviceModel = deviceModel;
        this.price = price;
        this.creationDate = creationDate;
        this.description = description;
        this.isInStock = isInStock;
        this.factory = factory;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", deviceModel='" + deviceModel + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", description='" + description + '\'' +
                ", isInStock=" + isInStock +
                ", factory=" + factory +
                '}';
    }
}
