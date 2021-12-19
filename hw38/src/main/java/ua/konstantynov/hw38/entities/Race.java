package ua.konstantynov.hw38.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_race")
    private Long identifier;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Column(name = "horses_number")
    private int horseCount;

    @Column(name = "betting_on")
    private int horseNumber;

    @OneToMany(mappedBy = "race", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<ua.konstantynov.hw38.entities.Horse> horses;

    public Long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getHorseCount() {
        return horseCount;
    }

    public void setHorseCount(int horseCount) {
        this.horseCount = horseCount;
    }

    public int getHorseNumber() {
        return horseNumber;
    }

    public void setHorseNumber(int horseNumber) {
        this.horseNumber = horseNumber;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }
}
