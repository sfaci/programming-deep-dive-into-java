package space.harbour.exercises;

import space.harbour.exercises.util.RandomUtils;

import java.util.Random;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        final int LOWEST_VALUE = 0;
        final int HIGHEST_VALUE = 100;
        final int TRIES = 5;

        int numberToGuess = RandomUtils.getInteger(LOWEST_VALUE, HIGHEST_VALUE);
        int myTries = TRIES;

        while (myTries > 0) {
            System.out.println("Input your try");
            int userNumber = keyboard.nextInt();
            if (userNumber == numberToGuess) {
                System.out.println("You win!!");
                System.exit(0);
            } else if (userNumber > numberToGuess) {
                System.out.println("The number is lower");
            } else {
                System.out.println("The number is higher");
            }

            myTries--;
        }
    }
}