package space.harbour.exercises;

import java.util.Scanner;

public class Exercise1a {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type the first number: ");
        String first = keyboard.nextLine();
        if (!first.matches("[0-9]+")) {
            System.out.println("Error! It's not a number!");
            return;
        }
        int firstNumber = Integer.parseInt(first);

        System.out.print("Type the second number: ");
        String second = keyboard.nextLine();
        if (!second.matches("[0-9]+")) {
            System.out.println("Error! It's not a number!");
            return;
        }
        int secondNumber = Integer.parseInt(second);

        int lowestNumber = Math.min(firstNumber, secondNumber);
        int highestNumber = Math.max(firstNumber, secondNumber);

        for (int i = lowestNumber; i <= highestNumber; i++) {
            System.out.print(i + " ");
        }
    }
}