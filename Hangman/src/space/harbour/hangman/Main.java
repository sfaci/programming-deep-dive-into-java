package space.harbour.hangman;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        WordRandomizer wordRandomizer = new WordRandomizer();
        String randomWord = wordRandomizer.nextWord();
        System.out.println("My word is " + randomWord);
        char[] originalLetters = randomWord.toCharArray();

        char[] letters = new char[randomWord.length()];
        Arrays.fill(letters, '_');
        do {
            for (char letter : letters)
                System.out.print(letter + " ");
            System.out.println();

            System.out.println("Enter a letter");
            String letter = keyboard.nextLine();
            System.out.println("Your try is " + letter);
            int index = randomWord.indexOf(letter);
            if (index == -1) {
                System.out.println("Letter not found");
            } else {
                letters[index] = originalLetters[index];
            }
        } while (true);

        // TODO Draw hangman after every attempt
        // TODO Check if the user has guessed the complete word
        // TODO Check if a letter appears more than once
    }
}
