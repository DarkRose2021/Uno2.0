package com.company;

import java.util.ArrayList;

public class MainDeck{

    private ArrayList<String> unoDeck = new ArrayList<>();
    static ArrayList<String> playedCards = new ArrayList<>();

    public ArrayList<String> getUnoDeck() {
        return unoDeck;
    }

    public void buildDeck(){
        cardCreate("Red");
        cardCreate("Blue");
        cardCreate("Yellow");
        cardCreate("Green");
    }

    private void cardCreate(String color) {

        for (int wilds = 0; wilds < 2; wilds++) {
            switch (wilds){
                case 0:
                    unoDeck.add("Wild");
                    break;
                case 1:
                    unoDeck.add("Draw 4");
                    break;
            }
        }

        for (int zero = 0; zero < 1; zero++) {
            unoDeck.add(color + " " + zero);
        }

        for (int i = 0; i < 2; i++) {

            for (int regCards = 1; regCards < 10; regCards++) {
                unoDeck.add(color + " " + regCards);
            }

            for (int nonBasics = 0; nonBasics < 4; nonBasics++) {
                switch (nonBasics) {
                    case 1:
                        unoDeck.add(color + " " + "Skip");
                        break;
                    case 2:
                        unoDeck.add(color + " " + "Reverse");
                        break;
                    case 3:
                        unoDeck.add(color + " " + "Draw 2");
                        break;
                }
            }
        }
    }
}
