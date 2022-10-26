package space.harbour.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import space.harbour.demo.domain.Animal;
import space.harbour.demo.service.AnimalService;

import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping("/animals")
    public void addAnimal(@RequestBody Animal animal) {
        animalService.add(animal);
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animalService.findAll();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimals(@PathVariable long id) {
        return animalService.findById(id);
    }

    @DeleteMapping("/animals/{id}")
    public void deleteAnimal(@PathVariable long id) {
        animalService.remove(id);
    }
}
