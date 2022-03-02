package com.company;

import java.util.Scanner;

public class Console {
    static Scanner scanner = new Scanner(System.in);
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String RESET = "\u001B[0m";

    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";


    static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    static int getInteger(String prompt) {
        int i = 0;
        boolean valid = false;
        while (!valid) {
            try {
                i = Integer.parseInt(getString(prompt));
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.println("invalid integer");
            }
        }
        return i;
    }

    static float getFloat(String prompt) {
        float result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                result = Float.parseFloat(getString(prompt));
                valid = true;
            } catch (NumberFormatException ex) {
                setColor(RED_BACKGROUND);
                System.out.println("invalid float");
                setColor(RESET);
            }
        }
        return result;
    }

    static int getInteger(String prompt, int min, int max) {
        int i = 0;
        boolean valid = false;
        while (!valid) {
            try {
                i = Integer.parseInt(getString(prompt));
                valid = (i >= min && i <= max);
            } catch (NumberFormatException ex) {
                setColor(RED_BACKGROUND);
                System.out.println("invalid integer");
                setColor(RESET);
            }
        }
        return i;
    }

    public static void setColor(String color) {
        System.out.print(color);
    }

    public static void print(String string, String color) {
        Console.setColor(color);
        System.out.print(string);
        Console.setColor(Console.RESET);
    }

    public static void println(String string, String color) {
        Console.setColor(color);
        System.out.println(string);
        Console.setColor(Console.RESET);
    }
}

