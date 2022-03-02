package com.company;

import java.util.Random;

public class RNG {
    private static Random random = new Random();

    public static int getInt(int min, int max) {
        return random.nextInt(min, max);
    }

    public static int getInt(int max) {
        return random.nextInt(max);
    }

    public static double getDouble(double min, double max) {
        return random.nextDouble(min, max);
    }
}