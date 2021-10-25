package ua.konstantynov.hw24.objects;

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
    @Column(name = "device_id")
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

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "factory_identifier")
    private Factory factory;

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
