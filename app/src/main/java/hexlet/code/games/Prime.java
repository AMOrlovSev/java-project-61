package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static String task = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static String[][] gameQustionAnswer;
    private static String question;
    private static String correctAnswer;

    private static final int MAX_RANDOM = 1000;
    private static int randomValue;
    private static Random random = Engine.getRandom();

    public static void playGame() {
        gameQustionAnswer = fillQuestionAnswer();
        Engine.playGame(task, gameQustionAnswer);
    }

    private static String[][] fillQuestionAnswer() {
        gameQustionAnswer = new String[Engine.TOTAL_ATTEMP][Engine.GAME_QA];
        for (int i = 0; i < Engine.TOTAL_ATTEMP; i++) {
            randomValue = random.nextInt(MAX_RANDOM);

            question = String.valueOf(randomValue);
            correctAnswer = isPrime(randomValue) ? "yes" : "no";

            gameQustionAnswer[i][Engine.GAME_Q] = question;
            gameQustionAnswer[i][Engine.GAME_A] = correctAnswer;
        }
        return gameQustionAnswer;
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
