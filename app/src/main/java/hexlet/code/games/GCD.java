package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;

    private static int maxRandomValue = 100;
    private static int randomValue1;
    private static int randomValue2;

    private static String question;
    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();

    public static void playGame() {
        Cli.sayHello();

        numberOfCorrectAnswers = 0;

        Engine.sayTask("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < numberOfAttempts; i++) {
            randomValue1 = random.nextInt(maxRandomValue);
            randomValue2 = random.nextInt(maxRandomValue);

            question = randomValue1 + " " + randomValue2;
            Engine.sayQuestion(question);

            userAnswer = Engine.askAnswer();

            correctAnswer = String.valueOf(resultGCD(randomValue1, randomValue2));

            if (Engine.isCorrect(userAnswer, correctAnswer)) {
                numberOfCorrectAnswers++;
            } else {
                break;
            }
        }

        Engine.gameResult(numberOfCorrectAnswers, numberOfAttempts);
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
