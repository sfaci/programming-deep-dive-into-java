package space.harbour.exercises.util;

import java.util.Random;

public class RandomUtils {

    private RandomUtils() {

    }

    public static int getInteger(int minValue, int maxValue) {
        Random generator = new Random();
        return generator.nextInt(maxValue) + minValue;
    }


}
