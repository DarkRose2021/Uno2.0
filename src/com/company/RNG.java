package com.company;

import java.util.Random;

public class RNG {
    private static final Random random = new Random();

    public static int getInt(int min, int max) {
        return random.nextInt(min, max);
    }

    public static int getInt(int max) {
        return random.nextInt(max);
    }
}