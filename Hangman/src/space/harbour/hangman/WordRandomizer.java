package space.harbour.hangman;

import java.util.Random;

public class WordRandomizer {

    private String[] dictionary;

    public WordRandomizer() {
        dictionary = new String[9];
        dictionary[0] = "computer";
        dictionary[1] = "laptop";
        dictionary[2] = "table";
        dictionary[3] = "adapter";
        dictionary[4] = "student";
        dictionary[5] = "teacher";
        dictionary[6] = "slide";
        dictionary[7] = "program";
        dictionary[8] = "variable";
    }

    public String nextWord() {
        Random generator = new Random();
        int index = generator.nextInt(dictionary.length);
        return dictionary[index];
    }
}
