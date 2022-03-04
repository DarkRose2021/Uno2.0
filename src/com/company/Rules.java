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
        add option to add  ai players
     */

    String stackTop = "";

    String color = "";
    String number = "";
    String specialCase = "";

    SpecialCardRules cardRules = new SpecialCardRules();
    ArrayList<String> playableCards = new ArrayList<>();

    private void getColor(String topCard) {
        if (topCard.contains("Red")) {
            this.color = "Red";
        } else if (topCard.contains("Yellow")) {
            this.color = "Yellow";
        } else if (topCard.contains("Blue")) {
            this.color = "Blue";
        } else if (topCard.contains("Green")){
            this.color = "Green";
        }else{

            this.color = "Wild";

        }

    }

    private void getNumber(String topCard) {
        for (int posNumbs = 0; posNumbs < 10; posNumbs++) {
            if (topCard.contains("" + posNumbs)) {
                this.number = "" + posNumbs;
            }
        }
    }

    public ArrayList<String> checkForPlays(ArrayList<String> hand){

        //need to actually bring in stack Card/ grab from the stack, and make the stack, now realizing that im not sure if we've ever saved the stack itself . . . need tp ask katie about that tomorrow

        boolean cardsToPlay = false;

        if(isSpecial(hand, stackTop) || checkColor(hand, stackTop) || checkNumber(hand, stackTop)){

            cardsToPlay = true;

        }


        if(cardsToPlay == true){

            return playableCards;

        }

        return null;

    }

    private boolean isSpecial(ArrayList<String> hand, String stackTop){

        for (int handSize = 0; handSize < hand.size(); handSize++) {

            if (stackTop.contains("Draw 2") || stackTop.contains("Draw 4") || stackTop.contains("Skip") || stackTop.contains("Reverse") || stackTop.contains("Wild")) {

                getColor(stackTop);

                if(hand.get(handSize).contains("Wild")){

                    playableCards.add(String.valueOf(handSize));

                    return true;

                }

                if(hand.get(handSize).contains(color) != stackTop.contains(color)){

                    return false;

                }else{

                    playableCards.add(String.valueOf(handSize));

                    return true;

                }

            }

        }



        return true;

    }

    private boolean checkColor(ArrayList<String> hand, String stackTop){

        getColor(stackTop);

        for (int handSize = 0; handSize < hand.size(); handSize++) {

            if (hand.get(handSize).contains(color) != stackTop.contains(color)) {

                return false;

            }else{

                playableCards.add(String.valueOf(handSize));

                return true;

            }

        }

        return true;

    }

    private boolean checkNumber(ArrayList<String> hand, String stackTop){

        getNumber(stackTop);

        for (int handSize = 0; handSize < hand.size(); handSize++) {

            if(hand.get(Integer.parseInt(number)).contains(number) != stackTop.contains(number)){

                return false;

            }else{

                playableCards.add(String.valueOf(handSize));

                return true;

            }

        }

        return true;

    }

    public void checkTry(String cardPlayed, String stackTop) {

        getNumber(stackTop);

        if (cardPlayed.contains(specialCase)) {
            for (int specials = 0; specials < 6; specials++) {
                switch (specials) {
                    case 1:
                        if (specialCase.contains("Draw 2")) {
                            cardRules.draw2();
                        }
                        break;
                    case 2:
                        if (specialCase.contains("Draw 4")) {
                            //find way to call draw cards and change color
                            cardRules.draw4();

                            cardRules.wild();

                        }
                        break;
                    case 3:
                        if (specialCase.contains("Wild")) {
                            cardRules.wild();
                        }
                        break;
                    case 4:
                        if (specialCase.contains("Reverse")) {
                            //return thing to call a method to switch order
                            cardRules.reverse();
                        }
                        break;
                    case 5:
                        if (specialCase.contains("Skip")) {
                            //return thing to call a method to skip player, probs easiest, something like turn +1, then itll call the next turn method and skip person maybe.
                            cardRules.skip();
                        }
                        break;
                }
            }
        }

    }
}
