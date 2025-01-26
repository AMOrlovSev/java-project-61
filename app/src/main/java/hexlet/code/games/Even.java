package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
        String correctAnswer = isEven(randomValue) ? "yes" : "no";

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_POS_Q] = question;
        roundData[Engine.ROUND_POS_A] = correctAnswer;

        return roundData;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
