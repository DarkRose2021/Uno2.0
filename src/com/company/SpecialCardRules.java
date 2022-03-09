package com.company;

public class SpecialCardRules{
    void skip() {

        //Right here is the problem

        if (PlayerTurns.isReversed) {
            switch (PlayerTurns.currentPlayer) {
                case 0 -> PlayerTurns.currentPlayer = 2;
                case 1 -> PlayerTurns.currentPlayer = 3;
                case 2 -> PlayerTurns.currentPlayer = 0;
                case 3 -> PlayerTurns.currentPlayer = 1;
            }
        } else {
            switch (PlayerTurns.currentPlayer) {
                case 0 -> PlayerTurns.currentPlayer = 2;
                case 1 -> PlayerTurns.currentPlayer = 3;
                case 2 -> PlayerTurns.currentPlayer = 0;
                case 3 -> PlayerTurns.currentPlayer = 1;
            }
        }
    }

    void reverse() {
        PlayerTurns.isReversed = !PlayerTurns.isReversed;
    }

    void draw2() {
        switch (PlayerTurns.currentPlayer) {
            case 0 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(2, SetHands.hand3);
                } else {
                    Card.drawNumOfCards(2, SetHands.hand1);
                }
                PlayerTurns.currentPlayer = 2;
            }
            case 1 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(2, SetHands.playerHand);
                } else {
                    Card.drawNumOfCards(2, SetHands.hand2);
                }
                PlayerTurns.currentPlayer = 3;
            }
            case 2 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(2, SetHands.hand1);
                } else {
                    Card.drawNumOfCards(2, SetHands.hand3);
                }
                PlayerTurns.currentPlayer = 0;
            }
            case 3 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(2, SetHands.hand2);
                } else {
                    Card.drawNumOfCards(2, SetHands.playerHand);
                }
                PlayerTurns.currentPlayer = 1;
            }
        }
    }

    void draw4() {
        wild();
        switch (PlayerTurns.currentPlayer) {
            case 0 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(4, SetHands.hand3);
                } else {
                    Card.drawNumOfCards(4, SetHands.hand1);
                }
                PlayerTurns.currentPlayer = 2;
            }
            case 1 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(4, SetHands.playerHand);
                } else {
                    Card.drawNumOfCards(4, SetHands.hand2);
                }
                PlayerTurns.currentPlayer = 3;
            }
            case 2 -> {

                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(4, SetHands.hand1);
                } else {
                    Card.drawNumOfCards(4, SetHands.hand3);
                }
                PlayerTurns.currentPlayer = 0;
            }
            case 3 -> {
                if (PlayerTurns.isReversed) {
                    Card.drawNumOfCards(4, SetHands.hand2);
                } else {
                    Card.drawNumOfCards(4, SetHands.playerHand);
                }
                PlayerTurns.currentPlayer = 1;
            }
        }
    }

    void wild() {
        switch (PlayerTurns.currentPlayer) {
            case 0 -> chooseColor();
            case 1, 2, 3 -> randomColor();
        }
    }

    void chooseColor() {
        View.displayColor();
        int color = Console.getInteger("Choose a color: ", 1, 4);
        colors(color);
    }

    void randomColor() {
        int color = RNG.getInt(1, 4);
        colors(color);
    }

    private void colors(int color) {
        switch (color) {
            case 1 -> {//Red
                System.out.println("Color is now "+ Console.RED+ "red!"+ Console.RESET);
                Controller.faceCard = "Red";
            }
            case 2 -> {//Yellow
                System.out.println("Color is now "+ Console.YELLOW+ "yellow!"+ Console.RESET);
                Controller.faceCard = "Yellow";
            }
            case 3 -> {//Blue
                System.out.println("Color is now "+ Console.BLUE+ "blue!"+ Console.RESET);
                Controller.faceCard = "Blue";
            }
            case 4 -> {//Green
                System.out.println("Color is now "+ Console.GREEN+ "green!"+ Console.RESET);
                Controller.faceCard = "Green";
            }
        }
    }
}

