package com.company;

import java.util.ArrayList;

public class Win {
    static boolean isWinner = false; //change to true when the array is empty
    static int winner; //make the winner number their index in the array

    static void displayWinner(){
        switch (winner){
            case 0:
                System.out.println(Controller.players.get(0).toString()+ " is the winner!");
                break;
            case 1:
                System.out.println(Controller.players.get(1).toString()+ " is the winner!");
                break;
            case 2:
                System.out.println(Controller.players.get(2).toString()+ " is the winner!");
                break;
            case 3:
                System.out.println(Controller.players.get(3).toString()+ " is the winner!");
                break;
        }
    }

    static void setWinner(ArrayList<String> hand, int currentPlayer){
        if(hand.isEmpty()){
            winner = currentPlayer;
            isWinner = true;
        }
    }
}
