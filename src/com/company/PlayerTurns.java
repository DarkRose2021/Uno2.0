package com.company;

public class PlayerTurns {
    static int currentPlayer;
    static boolean isReversed = false;


    static String startingPlayer() {
        currentPlayer = RNG.getInt(0, 3);
        return switch (currentPlayer) {
            case 0 -> Controller.players.get(0).toString();
            case 1 -> Controller.players.get(1).toString();
            case 2 -> Controller.players.get(2).toString();
            case 3 -> Controller.players.get(3).toString();
            default -> null;
        };
    }

    static void nextPlayer() {
        if (!isReversed) {
            if(currentPlayer < 3){
                currentPlayer++;
            }else{
                currentPlayer = 0;
            }
        } else {
            if(currentPlayer > 0){
                currentPlayer --;
            }else{
                currentPlayer = 3;
            }
        }

    }

    static void turns() throws InterruptedException {
        while(!Win.isWinner) {
            if (currentPlayer == 0) {
                HumanPlayer.userTurn();
            } else if (currentPlayer == 1) {
                AIPlayer.player1Turn();
            } else if (currentPlayer == 2) {
                AIPlayer.player2Turn();
            } else if (currentPlayer == 3){
                AIPlayer.player3Turn();
            }
        }
    }
}
