package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static String task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MAX_VALUE = 1000;

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ATTEMPTS][Engine.ROUND_ARRAY_LENGTH];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(task, gameData);
    }

    public static String[] generateRoundData() {
        int randomValue = Utils.getRandom(MAX_VALUE);

        String question = String.valueOf(randomValue);
        String correctAnswer = isPrime(randomValue) ? "yes" : "no";

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_POS_Q] = question;
        roundData[Engine.ROUND_POS_A] = correctAnswer;

        return roundData;
    }

    private static boolean isPrime(int value) {
        for (int i = 2; i < (value + 1) / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
