package space.harbour.animalcollection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        Animal animal1 = new Animal("Toby", 50, 10);
        Animal animal2 = new Animal("Toby", 190, 9);
        Animal animal3 = new Animal("Sam", 100, 100);

        animals.add(animal1);
        animals.add(animal2);
        animals.add(animal3);

        System.out.println(animals);

        animals.add(new Animal("asdasd", 1, 1));
        System.out.println(animals);

        Set<Animal> animalSet = new TreeSet<>(animals);
        animals.clear();
        animals.addAll(animalSet);

        System.out.println(animals);

        // How many animals I have (and some criteria, weight > 10)
        long count = animals.stream()
                .filter(animal -> animal.getWeight() > 10)
                .filter(animal -> animal.getSpeed() < 100)
                .count();

        // Total weight of all animals
        double totalWeight = animals.stream()
                .mapToDouble(Animal::getWeight)
                .sum();

        // Get the weight of all animals
        List<Double> weightList = animals.stream()
                .map(Animal::getWeight)
                .collect(Collectors.toList());

        // Get the names of all animals
        List<String> names = animals.stream()
                .map(Animal::getName)
                .collect(Collectors.toList());
    }
}
