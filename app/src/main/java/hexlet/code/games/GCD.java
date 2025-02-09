package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int MAX_VALUE = 100;
    private static final String TASK = "Find the greatest common divisor of given numbers.";

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ROUNDS][];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(TASK, gameData);
    }

    public static String[] generateRoundData() {
        int randomValue1 = 1 + Utils.randomNumber(MAX_VALUE - 1);
        int randomValue2 = 1 + Utils.randomNumber(MAX_VALUE - 1);

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_QUESTION] = randomValue1 + " " + randomValue2;
        roundData[Engine.ROUND_ANSWER] = String.valueOf(resultGCD(randomValue1, randomValue2));

        return roundData;
    }

    private static int resultGCD(int value1, int value2) {
        int a = value1;
        int b = value2;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
