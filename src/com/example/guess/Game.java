
package com.example.guess;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private final int randomNumber;
    private String permission;
    private final Scanner scanner;

    public String getPermission() {
        return permission;
    }

    public Game() {
        randomNumber = new Random().nextInt(100) + 1;
        scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = scanner.next();
        System.out.println("Hello " + userName);
    }

    public void requestPermission() {
        System.out.println("Start the game (y/n):");
        permission = scanner.next().toLowerCase();
    }

    private int getValidNumberInput() {
        int number = 0;
        boolean valid = false;
        do {
            try {
                number = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number:");
                scanner.next(); // Clear the invalid input
            }
        } while (!valid);
        return number;
    }

    private void guess(int userNum) {
        int attempts = 0;
        while (attempts < 5) {
            if (userNum == randomNumber) {
                System.out.println("You guessed the number!");
                System.out.println("It is: " + randomNumber);
                return;
            } else if (userNum > randomNumber) {
                System.out.println("Your guess is greater! Try again:");
            } else {
                System.out.println("Your guess is smaller! Try again:");
            }
            userNum = getValidNumberInput();
            attempts++;
        }
        System.out.println("Game over! The number was: " + randomNumber);
    }

    public void start() {
        System.out.println("Start guessing...");
        System.out.println("You have five chances!");
        int userNumber = getValidNumberInput();
        guess(userNumber);
    }
}