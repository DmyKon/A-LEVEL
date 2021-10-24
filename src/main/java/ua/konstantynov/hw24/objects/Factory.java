package ua.konstantynov.hw24.objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@ToString
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "factory")
public class Factory {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column (name = "factory_id")
    private String id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "factory")
    private Set<Device> deviceSet;
}