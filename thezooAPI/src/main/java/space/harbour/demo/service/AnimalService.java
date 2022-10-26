package space.harbour.demo.service;

import org.springframework.stereotype.Service;
import space.harbour.demo.domain.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> findAll();
    Animal findById(long id);
    Animal findByName(String name);
    List<Animal> findByRace(String race);
    List<Animal> findByRaceAndMaxSpeed(String race, int maxSpeed);
    void add(Animal animal);
    void remove(long id);
    void modify(Animal animal);
}
