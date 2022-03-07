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
    ArrayList<String> playableCards = new ArrayList<>();

    private void getColor(String topCard) {
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
    }

    private void getNumber(String topCard) {
        for (int posNumbs = 0; posNumbs < 10; posNumbs++) {
            if (topCard.contains("" + posNumbs)) {
                this.number = "" + posNumbs;
            }
        }
    }

    public ArrayList<String> checkForPlays(ArrayList<String> hand) {

        ArrayList<String> playableCards = new ArrayList<>();

        boolean cardsToPlay = false;

        for (int checkedCards = 0; checkedCards < hand.size(); checkedCards++) {

            if (isSpecial(hand, stackTop) == true || checkColor(hand, stackTop) == true || checkNumber(hand, stackTop) == true) {

                playableCards.add(hand.get(checkedCards));

                cardsToPlay = true;

            }

        }

        if (cardsToPlay) {
            return playableCards;
        }
        return null;
    }

    private boolean isSpecial(ArrayList<String> hand, String stackTop) {
        for (int handSize = 0; handSize < hand.size(); handSize++) {
            if (stackTop.contains("Draw 2") || stackTop.contains("Draw 4") || stackTop.contains("Skip") || stackTop.contains("Reverse") || stackTop.contains("Wild")) {
                getColor(stackTop);
                if (hand.get(handSize).contains("Wild") || hand.get(handSize).contains("Draw 4")) {
                    playableCards.add(String.valueOf(handSize));
                    return true;
                }

                if (hand.get(handSize).contains(color) != stackTop.contains(color)) {
                    return false;

                } else {
                    playableCards.add(String.valueOf(handSize));
                    return true;
                }
            }
        }
        return true;
    }

    private boolean checkColor(ArrayList<String> hand, String stackTop) {
        getColor(stackTop);

        for (int handSize = 0; handSize < hand.size(); handSize++) {
            if(hand.get(handSize).contains("Wild") || hand.get(handSize).contains("Draw 4")){

                return true;

            }else if(hand.get(handSize).contains(color) != stackTop.contains(color)) {
                return false;
            }else{
                playableCards.add(String.valueOf(handSize));
                return true;
            }
        }
        return true;
    }

    private boolean checkNumber(ArrayList<String> hand, String stackTop) {
        getNumber(stackTop);

        for (int handSize = 0; handSize < hand.size(); handSize++) {

            if(hand.get(handSize).contains("Wild") || hand.get(handSize).contains("Draw 4")){

                return true;

            }else if(hand.get(handSize) != stackTop) {

                return false;

            } else {
                playableCards.add(String.valueOf(handSize));
                return true;
            }
        }
        return true;
    }

//    void checkCard(ArrayList<String> hand) {
//        boolean didTurn = false;
//        ArrayList<String> cardsCanPlay = hand;
//
//        if (cardsCanPlay.isEmpty()) {
//            Card.drawNumOfCards(1, SetHands.playerHand);
//            HumanPlayer. = true;
//        } else {
//            if (SetHands.playerHand.contains(cardChoice)) {
//                if (cardChoice.equals("Wild")) {
//                    cardRules.wild();
//                    Controller.faceCard = cardChoice;
//                    SetHands.playerHand.remove(cardChoice);
//                    MainDeck.playedCards.add(cardChoice);
//
//                } else if (cardChoice.equals("Draw 4")) {
//                    cardRules.draw4();
//                    Controller.faceCard = cardChoice;
//                    SetHands.playerHand.remove(cardChoice);
//                    MainDeck.playedCards.add(cardChoice);
//
//                } else if (cardChoice.contains("Draw 2")) {
//                    cardRules.draw2();
//                    Controller.faceCard = cardChoice;
//                    SetHands.playerHand.remove(cardChoice);
//                    MainDeck.playedCards.add(cardChoice);
//
//                } else if (cardChoice.contains("Reverse")) {
//                    cardRules.reverse();
//                    Controller.faceCard = cardChoice;
//                    SetHands.playerHand.remove(cardChoice);
//                    MainDeck.playedCards.add(cardChoice);
//
//                } else if (cardChoice.contains("Skip")) {
//                    cardRules.skip();
//                    Controller.faceCard = cardChoice;
//                    SetHands.playerHand.remove(cardChoice);
//                    MainDeck.playedCards.add(cardChoice);
//
//                } else {
//                    Controller.faceCard = cardChoice;
//                    SetHands.playerHand.remove(cardChoice);
//                    MainDeck.playedCards.add(cardChoice);
//                }
//                didTurn = true;
//            } else {
//                System.out.println("Card not found");
//                didTurn = false;
//            }
//        }
    }
