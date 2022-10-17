package space.harbour.exercises;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type the first number: ");
        int firstNumber = keyboard.nextInt();
        System.out.print("Type the second number: ");
        int secondNumber = keyboard.nextInt();
        for (; firstNumber <= secondNumber; firstNumber++) {
            System.out.print(firstNumber + " ");
        }
    }
}