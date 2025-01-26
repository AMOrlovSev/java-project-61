package hexlet.code;

import java.util.Random;

public class Utils {
    private static Random random = new Random();

    public static int getRandom(int value) {
        return random.nextInt(value);
    }
}
