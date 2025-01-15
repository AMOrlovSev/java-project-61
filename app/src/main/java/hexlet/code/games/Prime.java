package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;

    private static final int MAX_RANDOM = 1000;
    private static int randomValue;

    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();

    public static void playGame() {
        Cli.sayHello();

        numberOfCorrectAnswers = 0;

        Engine.sayTask("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        steps(numberOfAttempts);

        Engine.gameResult(numberOfCorrectAnswers, numberOfAttempts);
    }

    private static void steps(int numberAttempts) {
        for (int i = 0; i < numberAttempts; i++) {
            randomValue = random.nextInt(MAX_RANDOM);

            Engine.sayQuestion(String.valueOf(randomValue));

            userAnswer = Engine.askAnswer();

            correctAnswer = isPrime(randomValue) ? "yes" : "no";

            if (Engine.isCorrect(userAnswer, correctAnswer)) {
                numberOfCorrectAnswers++;
            } else {
                break;
            }
        }
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
