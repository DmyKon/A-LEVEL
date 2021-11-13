package ua.konstantynov.hw24_hibernate.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "factory")
public class Factory {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "factory_id", columnDefinition = "varchar(36)")
    private String id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "factory", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<Device> deviceSet;

    public Factory(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}