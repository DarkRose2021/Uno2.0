package com.company;

public class PlayerTurns {
    static int currentPlayer;
    static boolean isReversed = false;


    static String startingPlayer(){
        currentPlayer = RNG.getInt(0,3);
        return switch (currentPlayer) {
            case 0 -> Controller.players.get(0).toString();
            case 1 -> Controller.players.get(1).toString();
            case 2 -> Controller.players.get(2).toString();
            case 3 -> Controller.players.get(3).toString();
            default -> null;
        };
    }

    static void nextPlayer(){
        if (isReversed) {
            switch (currentPlayer) {
                case 0: {
                    currentPlayer = 3;
                }
                case 1,2,3: {
                    currentPlayer--;
                }
            }
        } else {
            switch (currentPlayer) {
                case 0,1,2: {
                    currentPlayer++;
                }
                case 3: {
                    currentPlayer = 0;
                }
            }
        }
    }
}

