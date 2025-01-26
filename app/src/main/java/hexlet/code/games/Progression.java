package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;

public class Progression {
    private static String task = "What number is missing in the progression?";
    private static final int TOTAL_NUMS = 10;
    private static final int MAX_VALUE = 10;
    private static final int MAX_STEP = 10;
    private static final int MIN_STEP = 2;

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ATTEMPTS][Engine.ROUND_ARRAY_LENGTH];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(task, gameData);
    }

    public static String[] generateRoundData() {
        int firstRandomValue = Utils.getRandom(MAX_VALUE);
        int randomStep = MIN_STEP + (int) (Math.random() * ((MAX_STEP - MIN_STEP) + 1));

        String[] progression = createProgression(TOTAL_NUMS, firstRandomValue, randomStep);
        int unknownRandomValue = Utils.getRandom(TOTAL_NUMS);
        String temp = String.valueOf(progression[unknownRandomValue]);
        progression[unknownRandomValue] = "..";

        String question = Arrays.toString(progression);
        question = question.replace("[", "").replace("]", "").replace(",", "");

        String correctAnswer = String.valueOf(temp);

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_POS_Q] = question;
        roundData[Engine.ROUND_POS_A] = correctAnswer;

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
