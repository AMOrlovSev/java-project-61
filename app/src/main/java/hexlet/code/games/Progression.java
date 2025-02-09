package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    private static final int TOTAL_NUMS = 10;
    private static final int MAX_VALUE = 10;
    private static final int MAX_STEP = 10;
    private static final int MIN_STEP = 2;
    private static final String TASK = "What number is missing in the progression?";

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ROUNDS][];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(TASK, gameData);
    }

    public static String[] generateRoundData() {
        int firstRandomValue = Utils.randomNumber(MAX_VALUE);
        int randomStep = MIN_STEP + (int) (Math.random() * ((MAX_STEP - MIN_STEP) + 1));

        String[] progression = createProgression(TOTAL_NUMS, firstRandomValue, randomStep);
        int unknownRandomValue = Utils.randomNumber(TOTAL_NUMS);
        String temp = String.valueOf(progression[unknownRandomValue]);
        progression[unknownRandomValue] = "..";

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_QUESTION] = String.join(" ", progression);
        roundData[Engine.ROUND_ANSWER] = String.valueOf(temp);

        return roundData;
    }

    private static String[] createProgression(int totalNums, int firstNum, int step) {
        String[] progres = new String[totalNums];
        for (int i = 0; i < totalNums; i++) {
            progres[i] = String.valueOf(firstNum + step * i);
        }
        return progres;
    }
}
