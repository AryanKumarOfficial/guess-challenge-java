package com.example.guess;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");
        Game game = new Game();
        game.requestPermission();
        if (Objects.equals(game.getPermission(), "y")) {
            System.out.println("Starting game...");
            game.start();
        } else if (!Objects.equals(game.getPermission(), "n")) {
            System.out.println("Oops! Invalid input");
            System.out.println("Quitting the game...");
        } else {
            System.out.println("Quitting game...");
        }
    }
}