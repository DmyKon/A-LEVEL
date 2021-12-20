package ua.konstantynov.hw38.repository;

import org.springframework.data.repository.CrudRepository;
import ua.konstantynov.hw38.entities.Race;

public interface RaceRepository extends CrudRepository<Race, Integer> {
    Race findByIdentifier(Long identifier);
}
