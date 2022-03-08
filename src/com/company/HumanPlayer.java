package com.company;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    private static PrintCard card = new PrintCard();
    private static boolean playableCard = false;

    public HumanPlayer(String name) {
        super(name);
    }

    protected static void userTurn() throws InterruptedException {
        boolean didTurn = false;
        SpecialCardRules specialCardRules = new SpecialCardRules();
        Rules rules = new Rules();

        while (!didTurn) {
            playableCard = false;
            Win.setWinner(SetHands.playerHand, 0);
            card.printHand(SetHands.playerHand);
            View.playerTurn();
            int selection = Console.getInteger("Enter Selection: ", 1, 2);

            try {
                switch (selection) {
                    case 1: //Play Card
                        while (!playableCard) {
                            int cardNum = Console.getInteger("Enter index of the card you want to play: ", 0, SetHands.playerHand.size());
                            String cardChoice = SetHands.playerHand.get((cardNum - 1));


                            if (SetHands.playerHand.contains(cardChoice)) {
                                ArrayList<String> possibleCards = rules.checkTheCards(SetHands.playerHand, Controller.faceCard);

                            if (possibleCards.isEmpty()) {
                                Card.drawNumOfCards(1, SetHands.playerHand);
                                System.out.println("No Possible Cards Found, Enjoy This New Card!");
                                didTurn = true;
                                playableCard = true;
                                break;
                            }

                            for (int playerChoice = 0; playerChoice < SetHands.playerHand.size(); playerChoice++) {

                                    if (cardChoice.contains(possibleCards.get(playerChoice))) {

                                        if (cardChoice.equals("Wild")) {
                                            specialCardRules.wild();
                                            SetHands.playerHand.remove(cardChoice);
                                            MainDeck.playedCards.add(cardChoice);

                                            AIPlayer.specialCard = false;
                                            playableCard = true;
                                            break;

                                        } else if (cardChoice.equals("Draw 4")) {
                                            specialCardRules.draw4();
                                            SetHands.playerHand.remove(cardChoice);
                                            MainDeck.playedCards.add(cardChoice);

                                            AIPlayer.specialCard = true;
                                            playableCard = true;
                                            break;

                                        } else if (cardChoice.contains("Draw 2")) {
                                            specialCardRules.draw2();
                                            Controller.faceCard = cardChoice;
                                            SetHands.playerHand.remove(cardChoice);
                                            MainDeck.playedCards.add(cardChoice);

                                            AIPlayer.specialCard = true;
                                            playableCard = true;
                                            break;

                                        } else if (cardChoice.contains("Reverse")) {
                                            specialCardRules.reverse();
                                            Controller.faceCard = cardChoice;
                                            SetHands.playerHand.remove(cardChoice);
                                            MainDeck.playedCards.add(cardChoice);

                                            AIPlayer.specialCard = false;
                                            playableCard = true;
                                            break;

                                        } else if (cardChoice.contains("Skip")) {
                                            specialCardRules.skip();
                                            Controller.faceCard = cardChoice;
                                            SetHands.playerHand.remove(cardChoice);
                                            MainDeck.playedCards.add(cardChoice);

                                            AIPlayer.specialCard = true;
                                            playableCard = true;
                                            break;

                                        } else {
                                            Controller.faceCard = cardChoice;
                                            SetHands.playerHand.remove(cardChoice);
                                            MainDeck.playedCards.add(cardChoice);

                                            AIPlayer.specialCard = false;
                                            playableCard = true;
                                            break;
                                        }

                                    }

                                }
                                didTurn = true;
                            }
                            break;
                        }
                        break;

                    case 2:
                        Card.drawNumOfCards(1, SetHands.playerHand);
                        System.out.println(Controller.players.get(0).toString() + " drew a card");

                        didTurn = true;
                        break;
                }
            }catch (IndexOutOfBoundsException index){
                System.out.println("You must play a valid card");
            }
        }
        //Keep at end of method. moves to next player
        card.printFaceCard(Controller.faceCard);
        System.out.println();
        AIPlayer.specialTurn();
    }

/*
    static void callUno() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Runnable r = () -> {

                String uno = Console.getString("Enter Uno");
                if (uno.equalsIgnoreCase("uno")) {
                    calledUno = true;
                    System.out.println(Controller.players.get(0).toString() + " called Uno!");
                } else {
                    calledUno = false;
                }
            };
            Future<?> f = service.submit(r);

            f.get(5, TimeUnit.SECONDS); // attempt the task for five seconds
        } catch (final InterruptedException e) {
            System.out.println(e.getMessage());
            // The thread was interrupted during sleep, wait or join
        } catch (final TimeoutException e) {
            System.out.println("Took too long! Cards will now be added to your deck");
            Card.drawNumOfCards(3, SetHands.playerHand);
        } catch (final ExecutionException e) {
            // An exception from within the Runnable task
        } finally {
            service.shutdown();
        }
    }
*/
}
