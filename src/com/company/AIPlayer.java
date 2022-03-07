package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    private static Rules rules = new Rules();
    private static PrintCard card = new PrintCard();
    private static boolean specialCard;

    //TODO let bots randomly draw a card from their deck that matches the face card or have them draw cards
    static void player1Turn() throws InterruptedException {
        Win.setWinner(SetHands.hand1, 1);
        turnDo(SetHands.hand1, Controller.players.get(1).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand1, 1);
        Thread.sleep(2000);
    }

    static void player2Turn() throws InterruptedException {
        Win.setWinner(SetHands.hand3, 3);
        turnDo(SetHands.hand2, Controller.players.get(2).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand3, 3);
        Thread.sleep(2000);
    }

    static void player3Turn() throws InterruptedException {
        Win.setWinner(SetHands.hand3, 3);
        turnDo(SetHands.hand3, Controller.players.get(3).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand3, 3);
        Thread.sleep(2000);
    }

    private static void turnDo(ArrayList<String> currentPlayerHand, String name) throws InterruptedException {
        SpecialCardRules callRules = new SpecialCardRules();

        String card = rules.getACard(currentPlayerHand, Controller.faceCard);

//        String card = rules.checkBotHand(currentPlayerHand, Controller.faceCard);

        if (card != null) {
            if (card.contains("Reverse")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + card + ". Order is now reversed!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.reverse();

            } else if (card.contains("Skip")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + card + ". The next player gets skipped!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.skip();
                specialCard = true;

            } else if (card.contains("Draw 2")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + card + ". The next player gets skipped and draws 2 cards!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.draw2();
                specialCard = true;

            } else if (card.equals("Draw 4")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + card + ". The next player gets skipped and draws 4 cards!");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.draw4();
                specialCard = true;
            } else if (card.equals("Wild")) {
                Controller.faceCard = card;
                System.out.println(name + " played a " + card + ".");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
                callRules.wild();
            } else {
                Controller.faceCard = card;
                System.out.println(name + " played a " + card + ".");
                currentPlayerHand.remove(card);
                MainDeck.playedCards.add(card);
            }
        } else {
            System.out.println(name + " drew a card.");
            Card.drawNumOfCards(1, currentPlayerHand);
        }
        specialTurn();
    }

    protected static void specialTurn() throws InterruptedException {
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
