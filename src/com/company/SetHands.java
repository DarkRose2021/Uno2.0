package com.company;

import java.util.ArrayList;

public class SetHands extends MainDeck{
    static ArrayList<String> playerHand = new ArrayList<>();
    static ArrayList<String> hand1 = new ArrayList<>();
    static ArrayList<String> hand2 = new ArrayList<>();
    static ArrayList<String> hand3 = new ArrayList<>();

    public void setPlayerHand(MainDeck deck, ArrayList<String> array){
        for (int cards = 0; cards < 7; cards++) {
            int hand = RNG.getInt(deck.getUnoDeck().size());
            String startingHand = deck.getUnoDeck().get(hand);
            array.add(startingHand);
            deck.getUnoDeck().remove(startingHand);
            MainDeck.playedCards.add(startingHand);
        }
    }
}
