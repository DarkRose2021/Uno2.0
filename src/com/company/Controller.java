package com.company;

import java.util.ArrayList;
import java.util.Currency;

public class Controller {
    MainDeck deck = new MainDeck();
    Card card = new Card();
    SetHands setHands = new SetHands();
    static ArrayList<Player> players = new ArrayList<>();
    static String faceCard;
    PrintCard currentCard = new PrintCard();

    public void run() throws InterruptedException {
        boolean quit = false;
        while (!Win.isWinner && !quit) {
            View.displayMenu();
            int selection = Console.getInteger("Would you like to play a game Uno? ", 1, 2);
            switch (selection) {
                case 1:
                    deck.buildDeck();
                    deck.getUnoDeck();
//                  System.out.println(deck.getUnoDeck().size());
                    faceCard = card.genFirstCard(deck);

                    //Setting User's name and hand
                    String usersName = Console.getString("Please Enter Your Name: ");
                    HumanPlayer user = new HumanPlayer(usersName);
                    players.add(user);
                    setHands.setPlayerHand(deck, SetHands.playerHand);

                    //Creating 3 AI players and generating their hand
                    for (int i = 0; i < 3; i++) {
                        String name = Console.getString("Enter Name for The AI Player: ");
                        AIPlayer aiPlayer = new AIPlayer(name);
                        players.add(aiPlayer);

                        if (SetHands.hand1.isEmpty()) {
                            setHands.setPlayerHand(deck, SetHands.hand1);
                        } else if (SetHands.hand2.isEmpty()) {
                            setHands.setPlayerHand(deck, SetHands.hand2);
                        } else if (SetHands.hand3.isEmpty()) {
                            setHands.setPlayerHand(deck, SetHands.hand3);
                        }
                    }

                    System.out.println();
//                    currentCard.setCard(faceCard);

                    System.out.println();

                    currentCard.printHand(SetHands.playerHand);

                    //Randomly chooses first player
                    PlayerTurns.startingPlayer();
                    View.displayTurn();

                    //Print Face Card
                    currentCard.setCard(faceCard);
                    System.out.println("Face card");


                    break;
                case 2:
                    quit = true;
                    break;
            }
        }
        Win.displayWinner();
        //after we have users choose card,
        // we should call the rules and check, then somewhere in have if(cards in hand == 1 add option (press uno), give the player about 5 seconds,
        // and if pressed

    }
}

