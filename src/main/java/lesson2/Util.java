package lesson2;

import java.util.Random;

public class Util {
    public static int getRandom(int min, int max) {
        int result = 0;
        Random random = new Random();
        do {
            result = random.nextInt(max + 1);
        } while (result < min);
        return result;
    }

    public static int[] getRandomIntArray(int min, int max, int length) {
        int[] result = new int[length];
        for (int i = 0; i < result.length; i++) {
            result[i] = getRandom(min, max);
        }
        return result;
    }

}