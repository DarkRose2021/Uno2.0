package com.company;

import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    private static final Rules rules = new Rules();
    protected static boolean specialCard;
    private static final PrintCard printCard = new PrintCard();

    static void player1Turn() throws InterruptedException {
        AITurn(SetHands.hand1, Controller.players.get(1).toString());
        Win.setWinner(SetHands.hand1, 1);
        //Keep at end of method. moves to next player
        printCard.printFaceCard(Controller.faceCard);
        System.out.println();
        Thread.sleep(2000);
    }

    static void player2Turn() throws InterruptedException {
        AITurn(SetHands.hand2, Controller.players.get(2).toString());
        Win.setWinner(SetHands.hand3, 3);
        //Keep at end of method. moves to next player
        printCard.printFaceCard(Controller.faceCard);
        System.out.println();
        Thread.sleep(2000);
    }

    static void player3Turn() throws InterruptedException {
        AITurn(SetHands.hand3, Controller.players.get(3).toString());
        Win.setWinner(SetHands.hand3, 3);
        //Keep at end of method. moves to next player
        printCard.printFaceCard(Controller.faceCard);
        System.out.println();
        Thread.sleep(2000);

    }

    private static void AITurn(ArrayList<String> currentPlayerHand, String name){
        SpecialCardRules callRules = new SpecialCardRules();
        String card = rules.getACard(currentPlayerHand, Controller.faceCard);

        if (card != null) {
            if (card.contains("Reverse")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + printCard.printDisplayColors(card) + ". Order is now reversed!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.reverse();
                specialCard = false;

            } else if (card.contains("Skip")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + printCard.printDisplayColors(card) + ". The next player gets skipped!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.skip();
                specialCard = true;

            } else if (card.contains("Draw 2")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + printCard.printDisplayColors(card) + ". The next player gets skipped and draws 2 cards!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.draw2();
                specialCard = true;

            } else if (card.equals("Draw 4")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + printCard.printDisplayColors(card) + ". The next player gets skipped and draws 4 cards!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.draw4();
                specialCard = true;

            } else if (card.equals("Wild")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + printCard.printDisplayColors(card) + ".");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.wild();
                specialCard = false;

            } else {
                Controller.faceCard = card;
                System.out.println(name + " played a " + printCard.printDisplayColors(card) + ".");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                specialCard = false;
            }
        } else {
            System.out.println(name + " drew a card.");
            Card.drawNumOfCards(1, currentPlayerHand);
            specialCard = false;
        }
        specialTurn();
    }

    protected static void specialTurn() {
        if (specialCard && !PlayerTurns.isReversed) {
            switch (PlayerTurns.currentPlayer) {
                case 0 -> PlayerTurns.currentPlayer = 3;
                case 1, 2, 3 -> PlayerTurns.currentPlayer--;
            }
        }else if (specialCard && PlayerTurns.isReversed) {
            switch (PlayerTurns.currentPlayer) {
                case 3 -> PlayerTurns.currentPlayer = 0;
                case 1, 2, 0 -> PlayerTurns.currentPlayer--;
            }
        }
        PlayerTurns.nextPlayer();
    }
}
