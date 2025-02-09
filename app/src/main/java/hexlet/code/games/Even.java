package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    private static final int MAX_VALUE = 1000;
    private static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ROUNDS][];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(TASK, gameData);
    }

    public static String[] generateRoundData() {
        int randomValue = Utils.randomNumber(MAX_VALUE);

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_QUESTION] = String.valueOf(randomValue);
        roundData[Engine.ROUND_ANSWER] = isEven(randomValue) ? "yes" : "no";

        return roundData;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
