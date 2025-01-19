package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static String task = "Find the greatest common divisor of given numbers.";

    private static String[][] gameQustionAnswer;
    private static String question;
    private static String correctAnswer;

    private static final int MAX_VALUE = 100;
    private static int randomValue1;
    private static int randomValue2;
    private static Random random = Engine.getRandom();

    public static void playGame() {
        gameQustionAnswer = fillQuestionAnswer();
        Engine.run(task, gameQustionAnswer);
    }

    private static String[][] fillQuestionAnswer() {
        gameQustionAnswer = new String[Engine.TOTAL_ATTEMP][Engine.GAME_QA];
        for (int i = 0; i < Engine.TOTAL_ATTEMP; i++) {
            randomValue1 = 1 + random.nextInt(MAX_VALUE - 1);
            randomValue2 = 1 + random.nextInt(MAX_VALUE - 1);

            question = randomValue1 + " " + randomValue2;
            correctAnswer = String.valueOf(resultGCD(randomValue1, randomValue2));

            gameQustionAnswer[i][Engine.GAME_Q] = question;
            gameQustionAnswer[i][Engine.GAME_A] = correctAnswer;
        }
        return gameQustionAnswer;
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
