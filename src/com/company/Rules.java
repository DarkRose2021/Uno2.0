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

    String stackTop = "";

    String color = "";
    String number = "";
    //    String specialCase = "";
    //    SpecialCardRules cardRules = new SpecialCardRules();
    //    ArrayList<String> playableCards = new ArrayList<>();

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

//    private String checkSpecial(String topCard, String cardToCheck){
//
//        if(cardToCheck.contains("Reverse")){
//
//            getColor(topCard);
//
//            if(cardToCheck.contains(color)){
//
//                return cardToCheck;
//
//            }
//
//        }else if(cardToCheck.contains("Skip")){
//
//            getColor(topCard);
//
//            if(cardToCheck.contains(color)){
//
//                return cardToCheck;
//
//            }
//
//        }else if(cardToCheck.contains("Draw 2")){
//
//            getColor(topCard);
//
//            if (cardToCheck.contains(color)){
//
//                return cardToCheck;
//
//            }
//
//        }else{
//
//            return cardToCheck;
//
//        }
//
//        return null;
//
//    }

    public String getACard(ArrayList<String> hand, String faceCard){//for AI

        ArrayList<String> goodCards = new ArrayList<>();

        getNumber(faceCard);

        getColor(faceCard);

        for (int amountOfCards = 0; amountOfCards < hand.size(); amountOfCards++) {

            if (hand.get(amountOfCards).equals("Draw 4") || hand.get(amountOfCards).equals("Wild")){

                goodCards.add(hand.get(amountOfCards));

            }

            if(hand.get(amountOfCards).contains(color)|| hand.get(amountOfCards).contains(number)){

                goodCards.add(hand.get(amountOfCards));

            }

        }

        int cardPlay = RNG.getInt(goodCards.size());

        return goodCards.get(cardPlay);

    }

    String checkBotHand(ArrayList<String> hand, String faceCard){
        String card = String.valueOf(RNG.getInt(hand.size()));
        boolean canPlay = false;
        while (!canPlay){
            for (int handSize = 0; handSize < hand.size(); handSize++) {
                if(card.contains(getColor(faceCard)) || card.contains(getNumber(faceCard))){
                    canPlay = true;
                }else if(card.equals("Wild") || card.equals("Draw 4")){
                    canPlay = true;
                }
            }
            canPlay = false;
        }
        if (canPlay){
            return card;
        }else{
            return null;
        }
    }

//    String checkUserHand(ArrayList<String> hand, String faceCard, String playedCard){
//
//    }
}
