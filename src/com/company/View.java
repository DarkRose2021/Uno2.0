package com.company;

public class View {

    static void displayMenu(){
        System.out.println("[1] Yes");
        System.out.println("[2] No");
    }

    public static void playerTurn(){
        System.out.println(SetHands.playerHand);
        System.out.println("[1] Play card");
        System.out.println("[2] Draw card");
    }

    public static void playerCards(){
        for (int i = 0; i < SetHands.playerHand.size(); i++) {
            System.out.println(SetHands.playerHand.get(i));
        }
    }

    static void displayTurn(){
        System.out.println("It's " +PlayerTurns.startingPlayer()+ "'s turn.");
        System.out.println();
    }

    static void displayColor(){
        System.out.println("[1] Red");
        System.out.println("[2] Yellow");
        System.out.println("[3] Blue");
        System.out.println("[4] Green");
    }
}
