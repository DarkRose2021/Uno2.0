package com.company;

import java.util.ArrayList;

public class Rules {

    /* rules:
        player can only play a card if the color or number match, or they have a wild or draw 4
        reverse make the order go backwards
        draw 4 adds 4 randoms cards to nest player's hand
        player must enter uno before they play their 2nd to last card, or they get 3 random cards added to their hand
        draw 2 add 2 random cards to next player's hand
        2+ players, maybe max of 4
        add option to add  AI players
     */

    String color = "";
    String number = "";

    private String getColor(String topCard) {
        if (topCard.contains("Red")) {
            this.color = "Red";

        } else if (topCard.contains("Yellow")) {
            this.color = "Yellow";

        } else if (topCard.contains("Blue")) {
            this.color = "Blue";

        } else if (topCard.contains("Green")) {
            this.color = "Green";

        } else {
            this.color = "Wild";
        }
        return color;
    }

    private String getNumber(String topCard) {
        for (int posNumbs = 0; posNumbs < 10; posNumbs++) {
            if (topCard.contains("" + posNumbs)) {
                this.number = "" + posNumbs;
            }
        }

        if(topCard.contains("Skip")){
            this.number = "Skip";

        }else if(topCard.contains("Reverse")){
            this.number = "Reverse";

        }else if(topCard.contains("Draw 2")){
            this.number = "Draw 2";

        }else if(topCard.equals("Wild")){
            this.number = "Wild";

        }else if(topCard.equals("Draw 4")){
            this.number = ("Draw 4");
        }
        return number;
    }

    public String getACard(ArrayList<String> hand, String faceCard){//for AI
        ArrayList<String> goodCards = new ArrayList<>();

        getNumber(faceCard);
        getColor(faceCard);
        int cardPlay;

        checkForPlayableCards(hand, goodCards);

        if(!goodCards.isEmpty()){
            cardPlay = RNG.getInt(goodCards.size());
        }else{
            return null;
        }

        return goodCards.get(cardPlay);
    }

    public ArrayList<String> checkTheCards(ArrayList<String> hand, String faceCard){//for User
        ArrayList<String> possibleCards = new ArrayList<>();

        getNumber(faceCard);
        getColor(faceCard);

        checkForPlayableCards(hand, possibleCards);

        return possibleCards;
    }

    private void checkForPlayableCards(ArrayList<String> hand, ArrayList<String> goodCards) {
        for (String playedCard : hand) {
            if (playedCard.equals("Draw 4") || playedCard.equals("Wild")) {
                goodCards.add(playedCard);

            }else if(playedCard.contains(color) || playedCard.contains(number)){

                goodCards.add(playedCard);

            }
        }
    }
}
