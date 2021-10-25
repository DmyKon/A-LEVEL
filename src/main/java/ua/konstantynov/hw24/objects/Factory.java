package ua.konstantynov.hw24.objects;

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
    @Column(name = "factory_id")
    private String id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "factory", fetch = FetchType.EAGER)
    private Set<Device> deviceSet;

    @Override
    public String toString() {
        return "Factory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}