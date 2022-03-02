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

    String color = "";
    String number = "";
    String specialCase = "";
    SpecialCardRules cardRules = new SpecialCardRules();

    private void getColor(String topCard) {
        if (topCard.contains("Red")) {
            this.color = "Red";
        } else if (topCard.contains("Yellow")) {
            this.color = "Yellow";
        } else if (topCard.contains("Blue")) {
            this.color = "Blue";
        } else {
            this.color = "Green";
        }

    }

    private void getNumber(String topCard) {
        for (int posNumbs = 0; posNumbs < 10; posNumbs++) {
            if (topCard.contains("" + posNumbs)) {
                this.number = "" + posNumbs;
            }
        }
    }

    private void checkSpecial(String topCard) {
        if (topCard.contains("Draw 2") || topCard.contains("Draw 4") || topCard.contains("Skip") || topCard.contains("Reverse") || topCard.contains("Wild")) {
            this.specialCase = topCard;
        }
    }

    public void checkTry(String cardPlayed, String stackTop) {
        getColor(stackTop);
        getNumber(stackTop);
        //make sure to only check when things get played, might be a problem where things will overlap like the number isn't good but the color is, try to find way to make do good
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

        if (cardPlayed.contains(number) != stackTop.contains(number)) {
            System.out.println("invalid number, try color");
        }

        if (cardPlayed.contains(color) != stackTop.contains(color)) {
            System.out.println("invalid card, try again or draw a card");
        }
    }
}
