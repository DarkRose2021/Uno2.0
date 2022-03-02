package com.company;

import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    //TODO let bots randomly draw a card from their deck that matches the face card or have them draw cards
    static void player1Turn() throws InterruptedException {
        //Keep at end of method. moves to next player
        Thread.sleep(1000);
        PlayerTurns.nextPlayer();
    }

    static void player2Turn() throws InterruptedException {
        //Keep at end of method. moves to next player
        Thread.sleep(1000);
        PlayerTurns.nextPlayer();
    }

    static void player3Turn() throws InterruptedException {
        //Keep at end of method. moves to next player
        Thread.sleep(1000);
        PlayerTurns.nextPlayer();
    }

    private void turnDo(){

        //brain finish thoughts for --\/, its supposed to add the ai's playable cards to an array then choose 1 at random, then if not possible they draw, then call this method for each perp

        ArrayList<String> playableCards = new ArrayList<>();

        for (int cardsInHand = 0; cardsInHand < SetHands.hand1.size(); cardsInHand++) {

//            if(cardsInHand == playable){





        }

    }

//    SetHands.hand1 bot1hand

}

