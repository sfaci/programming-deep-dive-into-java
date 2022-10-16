package space.harbour.animalcollection;

public class Animal implements Comparable<Animal> {

    private String name;
    private double weight;
    private int speed;

    public Animal(String name, float weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;

        if (!(object instanceof Animal))
            return false;

        Animal otherAnimal = (Animal) object;
        return name.equals(otherAnimal.getName());
    }

    @Override
    public String toString() {
        return "Name=" + name + ", weight=" + weight;
    }

    @Override
    public int compareTo(Animal animal) {
        return (int) (weight - animal.getWeight());
    }
}
