package com.company;

import java.util.ArrayList;

public class PrintCard {
    String cardColor = "";
    String cardNum = "";
    String colorReset = "" + Console.RESET;

    public void printHand(ArrayList<String> playerHand) {
        int index = 1;
        for (String cards : playerHand) {
            getInfo(cards);
            System.out.print("["+index+"] "+ cardColor + cards + colorReset + ", ");
            index++;
        }
    }

    public void printFaceCard(String faceCard) {
        getInfo(faceCard);
        System.out.println("Face Card: " + cardColor + faceCard + colorReset);
    }

    public String printDisplayColors(String card) {
        getInfo(card);
        return cardColor + card + colorReset;
    }

    private void getInfo(String cardPlayed) {
        if (cardPlayed.contains("Red")) {
            this.cardColor = "" + Console.RED;

        } else if (cardPlayed.contains("Blue")) {
            this.cardColor = "" + Console.BLUE;

        } else if (cardPlayed.contains("Yellow")) {
            this.cardColor = "" + Console.YELLOW;

        } else if (cardPlayed.contains("Green")) {
            this.cardColor = "" + Console.GREEN;

        } else {
            this.cardColor = "" + Console.PURPLE;
        }

        for (int number = 0; number < 10; number++) {
            if (cardPlayed.contains(("" + number))) {
                this.cardNum = "" + number;
            }
        }
    }
}
