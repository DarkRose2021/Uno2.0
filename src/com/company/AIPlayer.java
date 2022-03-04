package com.company;

import java.util.ArrayList;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }

    Rules rules = new Rules();

    //TODO let bots randomly draw a card from their deck that matches the face card or have them draw cards
    static void player1Turn() throws InterruptedException {
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand1, 1);
        Thread.sleep(1000);
        PlayerTurns.nextPlayer();
    }

    static void player2Turn() throws InterruptedException {
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand2, 2);
        Thread.sleep(1000);
        PlayerTurns.nextPlayer();
    }

    static void player3Turn() throws InterruptedException {
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand3, 3);
        Thread.sleep(1000);
        PlayerTurns.nextPlayer();
    }

    private void turnDo(ArrayList<String> currentPlayerHand){

      ArrayList<String> currentAIHand = currentPlayerHand;

      ArrayList<String> cardsToPlay = rules.checkForPlays(currentAIHand);

      if(cardsToPlay.isEmpty()){

          //call the method from wherever we have people draw cards, unsure where and starting to run low on braincells

      }else{

          int cardPlay = getInt(0,cardsToPlay.size());

          if(cardsToPlay.contains("Wild")){

              //use the rng class, currently unsure why it no work, to make switch for random colors

          }else{

              //have the AI play the random card generated from list returned, i still believe we need to grab the stacks top or something, will continue tomorrow

          }

      }

    }

}

