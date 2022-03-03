package com.company;

public class PrintCard {

    String[][] card = new String[5][5];

    String cardColor = "";

    String cardNum = "";

    String colorReset = "" + Console.RESET;

    private void getInfo(String cardPlayed){

        if(cardPlayed.contains("Red")){

            this.cardColor = "" + Console.RED;

        }else if(cardPlayed.contains("Blue")){

            this.cardColor = "" + Console.BLUE;

        }else if(cardPlayed.contains("Yellow")){

            this.cardColor = "" + Console.YELLOW;

        }else if(cardPlayed.contains("Green")){

            this.cardColor = "" + Console.GREEN;

        }

        for (int number = 0; number < 10; number++) {

            if(cardPlayed.contains(("" + number))){

                this.cardNum = "" + number;

            }

        }

    }

    public void cardPrinter(String cardPlayed){

        getInfo(cardPlayed);

        card[0][0] = cardColor + "/";

        card[0][1] = "¯";

        card[0][2] = "⧵";

        card[1][0] = "|";

        card[1][2] = "|";

        card[2][0] = "|";

        card[2][1] = cardNum;

        card[2][2] = "|";

        card[3][0] = "|";

        card[3][2] = "|";

        card[4][0] = "⧵";

        card[4][1] = "_";

        card[4][2] = "/" + colorReset; //Color reset thing iant working, unsure why

        //for some reason the thing only works if it has extra spaces and even then it doesn't fully work,

        //down below is an attempt for a temporary fix to make the extra bits null, it doesnt currently work as is

//        for (int upDown = 0; upDown < 5; upDown++) {
//
//            for (int leftRight = 0; leftRight < 5; leftRight++) {
//
//                if(card[upDown][leftRight] != null) {
//
//                    card[upDown][leftRight] = String.valueOf(' ');
//
//                }
//
//            }
//
//        }

        for (int rows = 0; rows < 6; rows++) {

            //

            if(rows <= 5) {

                Console.println("",colorReset);

            }

            for (int collums = 0; collums < 5; collums++) {

                System.out.print(card[rows][collums]);

            }

        }

    }

}
