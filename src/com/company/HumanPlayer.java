package com.company;

import java.util.Timer;
import java.util.concurrent.*;

public class HumanPlayer extends Player {
    Timer timer = new Timer();
    boolean calledUno = false;

    public HumanPlayer(String name) {
        super(name);
    }

    static void userTurn(MainDeck deck) {
        if (PlayerTurns.currentPlayer == 0) {
            View.playerTurn();
            int selection = Console.getInteger("Enter selection: ", 1, 2);

            switch (selection) {
                case 1:
                    View.playerCards();
                    break;

                case 2:
                    for (int i = 0; i < 2; i++) {
                        SetHands.playerHand.add(Card.genRandomCard(deck, SetHands.playerHand));
                    }

                    break;
            }
        }
        //Keep at end of method. moves to next player

        PlayerTurns.nextPlayer();

    }

    void callUno() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        try {
            Runnable r = () -> {

                String uno =  Console.getString("Enter Uno");
                if(uno.equalsIgnoreCase("uno")){
                    calledUno = true;
                }else{
                    calledUno = false;
                }
            };

            Future<?> f = service.submit(r);

            f.get(5, TimeUnit.SECONDS); // attempt the task for five seconds
        } catch (final InterruptedException e) {
            // The thread was interrupted during sleep, wait or join
        } catch (final TimeoutException e) {
            // Took too long!
        } catch (final ExecutionException e) {
            // An exception from within the Runnable task
        } finally {
            service.shutdown();
        }
    }
}
