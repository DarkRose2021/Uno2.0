package com.company;

import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    private static Rules rules = new Rules();
    private static PrintCard card = new PrintCard();
    private static boolean specialCard;

    //TODO let bots randomly draw a card from their deck that matches the face card or have them draw cards
    static void player1Turn() throws InterruptedException {
        turnDo(SetHands.hand1, Controller.players.get(1).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand1, 1);
        Thread.sleep(2000);
        if (specialCard) {
            switch (PlayerTurns.currentPlayer) {
                case 0 -> PlayerTurns.currentPlayer = 3;
                case 1, 2, 3 -> PlayerTurns.currentPlayer--;
            }
        }
        PlayerTurns.nextPlayer();
    }

    static void player2Turn() throws InterruptedException {
        turnDo(SetHands.hand2, Controller.players.get(2).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand2, 2);
        Thread.sleep(2000);
        if (specialCard && !PlayerTurns.isReversed) {
            switch (PlayerTurns.currentPlayer) {
                case 0 -> PlayerTurns.currentPlayer = 3;
                case 1, 2, 3 -> PlayerTurns.currentPlayer--;
            }
        } else {
            switch (PlayerTurns.currentPlayer) {
                case 3 -> PlayerTurns.currentPlayer = 0;
                case 1, 2, 0 -> PlayerTurns.currentPlayer--;
            }
        }
        PlayerTurns.nextPlayer();
    }

    static void player3Turn() throws InterruptedException {
        turnDo(SetHands.hand3, Controller.players.get(3).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand3, 3);
        Thread.sleep(2000);
        if (specialCard) {
            switch (PlayerTurns.currentPlayer) {
                case 0 -> PlayerTurns.currentPlayer = 3;
                case 1, 2, 3 -> PlayerTurns.currentPlayer--;
            }
        }
        PlayerTurns.nextPlayer();
    }

    private static void turnDo(ArrayList<String> currentPlayerHand, String name) {
        SpecialCardRules callRules = new SpecialCardRules();
        ArrayList<String> cardsToPlay = new ArrayList<>();

        for (int cardsInHand = 0; cardsInHand < currentPlayerHand.size(); cardsInHand++) {

            if (currentPlayerHand.get(cardsInHand).contains("Wild")) {

                callRules.wild();

                Controller.faceCard = currentPlayerHand.get(cardsInHand);
                currentPlayerHand.remove(currentPlayerHand.get(cardsInHand));
                MainDeck.playedCards.add(currentPlayerHand.get(cardsInHand));
                System.out.println(name+ " played a "+ currentPlayerHand.get(cardsInHand));

                PlayerTurns.nextPlayer();


            }else if(currentPlayerHand.get(cardsInHand).contains("Draw 4")){

                callRules.draw4();

                Controller.faceCard = currentPlayerHand.get(cardsInHand);
                currentPlayerHand.remove(currentPlayerHand.get(cardsInHand));
                MainDeck.playedCards.add(currentPlayerHand.get(cardsInHand));
                System.out.println(name+ " played a "+ currentPlayerHand.get(cardsInHand));

                PlayerTurns.nextPlayer();

            }else if(currentPlayerHand.get(cardsInHand).contains("+2") && (currentPlayerHand.get(cardsInHand) == rules.color || currentPlayerHand.get(cardsInHand) == rules.number)){

                callRules.draw2();

                Controller.faceCard = currentPlayerHand.get(cardsInHand);
                currentPlayerHand.remove(currentPlayerHand.get(cardsInHand));
                MainDeck.playedCards.add(currentPlayerHand.get(cardsInHand));
                System.out.println(name+ " played a "+ currentPlayerHand.get(cardsInHand));

                PlayerTurns.nextPlayer();

            }else if(currentPlayerHand.get(cardsInHand).contains("Reverse")&& (currentPlayerHand.get(cardsInHand) == rules.color || currentPlayerHand.get(cardsInHand) == rules.number)){

                callRules.reverse();

                Controller.faceCard = currentPlayerHand.get(cardsInHand);
                currentPlayerHand.remove(currentPlayerHand.get(cardsInHand));
                MainDeck.playedCards.add(currentPlayerHand.get(cardsInHand));
                System.out.println(name+ " played a "+ currentPlayerHand.get(cardsInHand));

                PlayerTurns.nextPlayer();

            }else if(currentPlayerHand.get(cardsInHand).contains("Skip")&& (currentPlayerHand.get(cardsInHand) == rules.color || currentPlayerHand.get(cardsInHand) == rules.number)){

                callRules.skip();

                Controller.faceCard = currentPlayerHand.get(cardsInHand);
                currentPlayerHand.remove(currentPlayerHand.get(cardsInHand));
                MainDeck.playedCards.add(currentPlayerHand.get(cardsInHand));
                System.out.println(name+ " played a "+ currentPlayerHand.get(cardsInHand));

                PlayerTurns.nextPlayer();

            }else if(currentPlayerHand.get(cardsInHand) == rules.number || currentPlayerHand.get(cardsInHand) == rules.color){

                Controller.faceCard = currentPlayerHand.get(cardsInHand);
                currentPlayerHand.remove(currentPlayerHand.get(cardsInHand));
                MainDeck.playedCards.add(currentPlayerHand.get(cardsInHand));
                System.out.println(name+ " played a "+ currentPlayerHand.get(cardsInHand));

                PlayerTurns.nextPlayer();

            }else{

                Card.drawNumOfCards(1, currentPlayerHand);

                PlayerTurns.nextPlayer();

            }

        }
    }
}
