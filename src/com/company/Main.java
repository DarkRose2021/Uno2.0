package com.company;

public class Main {

    public static void main(String[] args) {
        try{
            Controller controller = new Controller();
            controller.run();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
