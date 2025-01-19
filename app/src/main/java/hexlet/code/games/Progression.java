package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    private static String task = "What number is missing in the progression?";

    private static String[][] gameQustionAnswer;
    private static String question;
    private static String correctAnswer;

    private static final int TOTAL_NUMS = 10;
    private static String[] progression;
    private static int unknownRandomValue;

    private static final int MAX_VALUE = 10;
    private static int firstRandomValue;

    private static final int MAX_STEP = 10;
    private static final int MIN_STEP = 2;
    private static int randomStep;

    private static Random random = Engine.getRandom();

    public static void playGame() {
        gameQustionAnswer = fillQuestionAnswer();
        Engine.playGame(task, gameQustionAnswer);
    }

    private static String[][] fillQuestionAnswer() {
        gameQustionAnswer = new String[Engine.TOTAL_ATTEMP][Engine.GAME_QA];
        for (int i = 0; i < Engine.TOTAL_ATTEMP; i++) {
            firstRandomValue = random.nextInt(MAX_VALUE);
            randomStep = MIN_STEP + (int) (Math.random() * ((MAX_STEP - MIN_STEP) + 1));

            progression = createProgression(TOTAL_NUMS, firstRandomValue, randomStep);

            unknownRandomValue = random.nextInt(TOTAL_NUMS);

            var temp = String.valueOf(progression[unknownRandomValue]);

            progression[unknownRandomValue] = "..";

            question = Arrays.toString(progression);
            question = question.replace("[", "").replace("]", "").replace(",", "");

            correctAnswer = String.valueOf(temp);

            gameQustionAnswer[i][Engine.GAME_Q] = question;
            gameQustionAnswer[i][Engine.GAME_A] = correctAnswer;
        }
        return gameQustionAnswer;
    }

    private static String[] createProgression(int totalNums, int firstNum, int step) {
        String[] progres = new String[totalNums];
        for (int i = 0; i < totalNums; i++) {
            progres[i] = String.valueOf(firstNum + step * i);
        }
        return progres;
    }
}
