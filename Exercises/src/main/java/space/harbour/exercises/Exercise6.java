package space.harbour.exercises;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {

    public static void main(String[] args) {
        int y = 10;
        aMethod(y);
        System.out.println(y);

        Person person = new Person();
        person.name = "Santi";
        changeName(person);
        System.out.println(person.name);

        Person anotherPerson = person;
        anotherPerson.name = "Maksim";
        System.out.println(person.name);

        List<String> wordList = new ArrayList<>();
        wordList.add("asdads");
        wordList.add("AsdaM");
    }

    public static void aMethod(int x) {
        x = 20;
    }

    public static void changeName(Person person) {
        person.name = "Peter";
    }
}
