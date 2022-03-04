package com.company;

import java.util.ArrayList;

public class Card extends MainDeck{

    //Generates a single random card that's not a special card. Used for the face card
    public String genFirstCard(MainDeck deck) {
        boolean checkCards = true;
        int cards = RNG.getInt(deck.getUnoDeck().size());
        String startingCard = deck.getUnoDeck().get(cards);

        do{
            if(startingCard.equals("Draw 4") || startingCard.equals("Wild") || startingCard.contains("Draw 2") || startingCard.contains("Skip") || startingCard.contains("Reverse")){
                cards = RNG.getInt(deck.getUnoDeck().size());
                startingCard = deck.getUnoDeck().get(cards);
            }else{
                checkCards = false;
            }
        }while(checkCards);
        deck.getUnoDeck().remove(startingCard);
        MainDeck.playedCards.add(startingCard);
        return startingCard;
    }

    //Generates a single random card. Used for drawing cards
    static void genRandomCard(MainDeck deck, ArrayList<String> player) {
        int cards = RNG.getInt(MainDeck.playedCards.size());
        String randomCard;

        if(deck.getUnoDeck().isEmpty()){
            randomCard = MainDeck.playedCards.get(cards);
            MainDeck.playedCards.remove(randomCard);
        }else{
            randomCard = deck.getUnoDeck().get(cards);
            deck.getUnoDeck().remove(randomCard);
        }
        player.add(randomCard);
    }

    static void drawNumOfCards(int numCards, ArrayList<String> player){
        for (int i = 0; i < numCards; i++) {
            genRandomCard(new MainDeck(), player);
        }
    }
}

