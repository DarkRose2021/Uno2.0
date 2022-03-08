package com.company;

public class View {
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
        System.out.println("[1] "+ Console.RED +"Red"+ Console.RESET);
        System.out.println("[2] "+ Console.YELLOW +"Yellow"+ Console.RESET);
        System.out.println("[3] "+ Console.BLUE +"Blue"+ Console.RESET);
        System.out.println("[4] "+ Console.GREEN +"Green"+ Console.RESET);
    }
}
