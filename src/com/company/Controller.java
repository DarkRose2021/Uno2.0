package com.company;

import java.util.ArrayList;

public class Controller {
    static MainDeck deck = new MainDeck();
    Card card = new Card();
    SetHands setHands = new SetHands();
    static ArrayList<Player> players = new ArrayList<>();
    static String faceCard;
    PrintCard currentCard = new PrintCard();

    public void run() throws InterruptedException {
        boolean quit = false;
        while (!quit) {
            View.displayMenu();
            int selection = Console.getInteger("Would you like to play a game Uno? ", 1, 2);

            while (!Win.isWinner) {
                //Clear hands if user wants to play again
                PlayerTurns.isReversed = false;
                SetHands.playerHand.clear();
                SetHands.hand1.clear();
                SetHands.hand2.clear();
                SetHands.hand3.clear();
                MainDeck.playedCards.clear();
                Win.isWinner = false;

                switch (selection) {
                    case 1 -> {
                        deck.buildDeck();
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

                        //Randomly chooses first player
                        System.out.println();
                        PlayerTurns.startingPlayer();
                        View.displayTurn();

                        //Print Face Card
                        currentCard.printFaceCard(faceCard);
                        PlayerTurns.turns();
                    }
                    case 2 -> quit = true;
                }
            }
            Win.displayWinner();
            int playAgain = Console.getInteger("Would you like to play again? ",1,2);
            switch (playAgain) {
                case 1 -> Win.isWinner = false;
                case 2 -> quit = true;
            }
        }
    }
}

