package space.harbour.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import space.harbour.demo.domain.Animal;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    List<Animal> findAll();
    Animal findByName(String name);
    List<Animal> findByRace(String race);
    List<Animal> findByRaceAndMaxSpeed(String race, int maxSpeed);
}
