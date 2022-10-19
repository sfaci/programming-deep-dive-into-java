package space.harbour.exercises;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Exercise1b {
    public static void main(String[] args) {
        String dni = "38383A";
        char[] characters = dni.toCharArray();
        System.out.println(characters[0]);


        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.print("Type the first number: ");
            int firstNumber = keyboard.nextInt();
            System.out.print("Type the second number: ");
            int secondNumber = keyboard.nextInt();

            int lowestNumber = Math.min(firstNumber, secondNumber);
            int highestNumber = Math.max(firstNumber, secondNumber);

            for (int i = lowestNumber; i <= highestNumber; i++) {
                System.out.print(i + " ");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Error! It's not a number");
        }
    }
}