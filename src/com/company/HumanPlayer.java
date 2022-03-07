package com.company;

import java.util.ArrayList;

public class HumanPlayer extends Player {
    //    Timer timer = new Timer();
//    static boolean calledUno = false;

    private static PrintCard card = new PrintCard();


    public HumanPlayer(String name) {
        super(name);
    }

    static void userTurn() throws InterruptedException {
        boolean didTurn = false;
        SpecialCardRules specialCardRules = new SpecialCardRules();

        Rules rules = new Rules();

        while (!didTurn) {
            playableCard = false;
            Win.setWinner(SetHands.playerHand, 0);
            card.printHand(SetHands.playerHand);
            View.playerTurn();
            int selection = Console.getInteger("Enter Selection: ", 1, 2);

            switch (selection) {
                case 1 -> {//Play Card
                    String cardChoice = Console.getString("Enter card of choice, (ex. Green 2, Wild, Red Reverse): ");
                    if (SetHands.playerHand.contains(cardChoice)) {

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
                            card.printFaceCard(Controller.faceCard);
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
        }
        //Keep at end of method. moves to next player
        Win.setWinner(SetHands.playerHand, 0);
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
