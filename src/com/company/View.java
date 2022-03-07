package com.company;

import java.util.ArrayList;

public class View {
    private static PrintCard printCard = new PrintCard();

    static void displayMenu() {
        System.out.println("[1] Yes");
        System.out.println("[2] No");
    }

    public static void playerTurn() {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("[1] Play card");
        System.out.println("[2] Draw card");
    }

    static void displayTurn() {
        System.out.println("It's " + PlayerTurns.startingPlayer() + "'s turn.");
        System.out.println();
    }

    static void displayColor() {
        System.out.println("[1] Red");
        System.out.println("[2] Yellow");
        System.out.println("[3] Blue");
        System.out.println("[4] Green");
    }
}
