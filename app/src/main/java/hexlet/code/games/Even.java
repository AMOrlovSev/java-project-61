package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static String task = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static String[][] gameQustionAnswer;
    private static String question;
    private static String correctAnswer;

    private static final int MAX_VALUE = 1000;
    private static int randomValue;
    private static Random random = Engine.getRandom();

    public static void playGame() {
        gameQustionAnswer = fillQuestionAnswer();
        Engine.playGame(task, gameQustionAnswer);
    }

    private static String[][] fillQuestionAnswer() {
        gameQustionAnswer = new String[Engine.TOTAL_ATTEMP][Engine.GAME_QA];
        for (int i = 0; i < Engine.TOTAL_ATTEMP; i++) {
            randomValue = random.nextInt(MAX_VALUE);

            question = String.valueOf(randomValue);
            correctAnswer = isEven(randomValue) ? "yes" : "no";

            gameQustionAnswer[i][Engine.GAME_Q] = question;
            gameQustionAnswer[i][Engine.GAME_A] = correctAnswer;
        }
        return gameQustionAnswer;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
