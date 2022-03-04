package com.company;

import java.util.ArrayList;
import java.util.Set;

public class AIPlayer extends Player {
    public AIPlayer(String name) {
        super(name);
    }
    private static Rules rules = new Rules();
    private static PrintCard card = new PrintCard();

    //TODO let bots randomly draw a card from their deck that matches the face card or have them draw cards
    static void player1Turn() throws InterruptedException {
        turnDo(SetHands.hand1, Controller.players.get(1).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand1, 1);
        Thread.sleep(2000);
        PlayerTurns.nextPlayer();
    }

    static void player2Turn() throws InterruptedException {
        turnDo(SetHands.hand2, Controller.players.get(2).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand2, 2);
        Thread.sleep(2000);
        PlayerTurns.nextPlayer();
    }

    static void player3Turn() throws InterruptedException {
        turnDo(SetHands.hand3, Controller.players.get(3).toString());
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.hand3, 3);
        Thread.sleep(2000);
        PlayerTurns.nextPlayer();
    }

    private static void turnDo(ArrayList<String> currentPlayerHand, String name){
      SpecialCardRules callRules = new SpecialCardRules();
      ArrayList<String> cardsToPlay = rules.checkForPlays(currentPlayerHand);

      if(cardsToPlay.isEmpty()){
          Card.drawNumOfCards(1, currentPlayerHand);
          System.out.println(name+ " drew a card");

      }else{
          int cardPlay = RNG.getInt(cardsToPlay.size());
          String playedCard = cardsToPlay.get(cardPlay);


          if(cardsToPlay.equals("Wild")){
              callRules.wild();
              Controller.faceCard = playedCard;
              currentPlayerHand.remove(playedCard);
              MainDeck.playedCards.add(playedCard);
              System.out.println(name+ " played a "+ playedCard);

          }else if(cardsToPlay.equals("Draw 4")){
              callRules.draw4();
              Controller.faceCard = playedCard;
              currentPlayerHand.remove(playedCard);
              MainDeck.playedCards.add(playedCard);
              System.out.println(name+ " played a "+ playedCard);
              //have the AI play the random card generated from list returned, i still believe we need to grab the stacks top or something, will continue tomorrow

          }else if(cardsToPlay.contains("Draw 2")){
              callRules.draw2();
              Controller.faceCard = playedCard;
              currentPlayerHand.remove("" + cardPlay);
              MainDeck.playedCards.add(playedCard);
              System.out.println(name+ " played a "+ playedCard);

          }else if(cardsToPlay.contains("Reverse")){
              callRules.reverse();
              Controller.faceCard = playedCard;
              currentPlayerHand.remove(playedCard);
              MainDeck.playedCards.add(playedCard);
              System.out.println(name+ " played a "+ playedCard);

          }else if(cardsToPlay.contains("Skip")){
              callRules.skip();
              Controller.faceCard = playedCard;
              currentPlayerHand.remove(playedCard);
              MainDeck.playedCards.add(playedCard);
              System.out.println(name+ " played a "+ playedCard);

          }else{
              Controller.faceCard = playedCard;
              currentPlayerHand.remove(playedCard);
              MainDeck.playedCards.add(playedCard);
              System.out.println(name+ " played a "+ playedCard);
          }
          System.out.println(name+ " played a "+ playedCard);
          card.printFaceCard(Controller.faceCard);
      }
    }
}

