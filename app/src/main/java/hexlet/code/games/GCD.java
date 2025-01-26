package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    private static final int MAX_VALUE = 100;

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ATTEMPTS][Engine.ROUND_ARRAY_LENGTH];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        String task = "Find the greatest common divisor of given numbers.";
        Engine.run(task, gameData);
    }

    public static String[] generateRoundData() {
        int randomValue1 = 1 + Utils.getRandom(MAX_VALUE - 1);
        int randomValue2 = 1 + Utils.getRandom(MAX_VALUE - 1);

        String question = randomValue1 + " " + randomValue2;
        String correctAnswer = String.valueOf(resultGCD(randomValue1, randomValue2));

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_POS_Q] = question;
        roundData[Engine.ROUND_POS_A] = correctAnswer;

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
