package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class Even {
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;

    private static int maxRandomValue = 1000;
    private static int randomValue;

    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();

    public static void playGame() {
        Cli.sayHello();

        numberOfCorrectAnswers = 0;

        Engine.sayTask("Answer 'yes' if the number is even, otherwise answer 'no'.");

        steps(numberOfAttempts);

        Engine.gameResult(numberOfCorrectAnswers, numberOfAttempts);
    }

    private static void steps(int numberAttempts) {
        for (int i = 0; i < numberAttempts; i++) {
            randomValue = random.nextInt(maxRandomValue);

            Engine.sayQuestion(String.valueOf(randomValue));

            userAnswer = Engine.askAnswer();

            correctAnswer = isEven(randomValue) ? "yes" : "no";

            if (Engine.isCorrect(userAnswer, correctAnswer)) {
                numberOfCorrectAnswers++;
            } else {
                break;
            }
        }
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
