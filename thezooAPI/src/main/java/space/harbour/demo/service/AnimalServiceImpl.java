package space.harbour.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.harbour.demo.domain.Animal;
import space.harbour.demo.repository.AnimalRepository;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal findById(long id) {
        // FIXME I have to check if there is something in the Optional
        return animalRepository.findById(id).get();
    }

    @Override
    public Animal findByName(String name) {
        return null;
    }

    @Override
    public List<Animal> findByRace(String race) {
        return null;
    }

    @Override
    public List<Animal> findByRaceAndMaxSpeed(String race, int maxSpeed) {
        return null;
    }

    @Override
    public void add(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public void remove(long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public void modify(Animal animal) {

    }
}
