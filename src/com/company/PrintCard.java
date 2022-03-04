package com.company;

import java.util.ArrayList;

public class PrintCard {

    String[][] card = new String[5][3];

    String cardColor = "";

    String cardNum = "";

    String colorReset = "" + Console.RESET;

    public void printHand(ArrayList<String> playerHand){

        for (String s : playerHand) {

            getInfo(s);

            setCard(s);

        }

    }

    private void getInfo(String cardPlayed){

        if(cardPlayed.contains("Red")){

            this.cardColor = "" + Console.RED;

        }else if(cardPlayed.contains("Blue")){

            this.cardColor = "" + Console.BLUE;

        }else if(cardPlayed.contains("Yellow")){

            this.cardColor = "" + Console.YELLOW;

        }else if(cardPlayed.contains("Green")){

            this.cardColor = "" + Console.GREEN;

        }else{

            this.cardColor = "" + Console.PURPLE;

        }

        for (int number = 0; number < 10; number++) {

            if(cardPlayed.contains(("" + number))){

                this.cardNum = "" + number;

            }

            switch (number){

                case 0:

                    if(cardPlayed.equals("Draw 2")){

                        this.cardNum = "+2";

                    }

                    break;

                case 1:

                    if(cardPlayed.equals("Draw 4")){

                        this.cardNum = "+4 W";

                    }

                    break;

                case 2:

                    if(cardPlayed.contains("Skip")){

                        this.cardNum = "(/)";

                    }

                    break;

                case 3:

                    if(cardPlayed.equals("Wild")){

                        this.cardNum = "W";

                    }

                    break;

                case 4:

                    if(cardPlayed.contains("Reverse")){

                        this.cardNum = "^|⧵/";

                    }

                    break;

            }

        }

    }

    public void setCard(String cardPlayed){

        getInfo(cardPlayed);

        card[0][0] = cardColor + "/";

        card[0][1] = "¯¯¯";

        card[0][2] = "⧵";

        card[1][0] = "|";

        card[1][1] = "   ";

        card[1][2] = "|";

        card[2][0] = "|";

        card[2][1] = " " + cardNum + " ";

        card[2][2] = "|";

        card[3][0] = "|";

        card[3][1] = "   ";

        card[3][2] = "|";

        card[4][0] = "⧵";

        card[4][1] = "___";

        card[4][2] = "/" + colorReset;

//        System.out.println();

        for(int i = 0; i < card.length; i++){

            System.out.println();

            for (int j = 0; j < card[i].length; j++) {

                System.out.print(card[i][j]);

            }

        }

        System.out.println();

    }

}
