package ua.konstantynov.hw38.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ua.konstantynov.hw38.service.RacesService;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@Entity
@Table(name = "horse")
public class Horse extends Thread {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_horse")
    private String identifier;

    @Column(name = "place")
    private volatile int place;

    @Column(name = "number")
    private int number;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_race")
    private Race race;

    @Override
    public void run() {
        Thread.currentThread().setName("Horse " + number);
        int distance = 1000;
        while (distance >= 0) {
            distance -= ThreadLocalRandom.current().nextInt(100, 201);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(400, 501));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        place = RacesService.incrementAndGetHorsePlace();
    }
}