package com.company;

public class PrintCard {

    String[][] card = new String[6][6];

    String cardColor = "";

    String cardNum = "";

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

        card[0][0] = "/" + cardColor;

        card[0][1] = "¯" + cardColor;

        card[0][2] = "⧵" + cardColor;

        card[1][0] = "|" + cardColor;

        card[1][2] = "|" + cardColor;

        card[2][0] = "|" + cardColor;

        card[2][1] = cardNum + cardColor;

        card[2][2] = "|" + cardColor;

        card[3][0] = "|" + cardColor;

        card[3][2] = "|" + cardColor;

        card[4][0] = "⧵" + cardColor;

        card[4][1] = "_" + cardColor;

        card[4][2] = "/" + cardColor;

        for (int rows = 0; rows < 3; rows++) {

            //brain me go figure way to do the rows then coullms right n stuff

            for (int collums = 0; collums < 5; collums++) {

                System.out.print(card[rows][collums]);

            }

        }

    }

}
