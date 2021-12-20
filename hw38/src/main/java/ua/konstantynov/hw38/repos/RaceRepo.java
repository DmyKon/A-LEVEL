package ua.konstantynov.hw38.repos;

import org.springframework.data.repository.CrudRepository;
import ua.konstantynov.hw38.entities.Race;

import java.util.List;

public interface RaceRepo extends CrudRepository<Race, Integer> {
    Race findByIdentifier(Long identifier);
}
