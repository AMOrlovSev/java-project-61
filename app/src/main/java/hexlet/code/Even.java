package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {

    private static final int numberOfAttempts = 3;
    private static final int maxRandomValue = 1000;
    private static int randomValue;

    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void playGame() {
        Cli.sayHello();

        int numberOfCorrectAnswers = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < numberOfAttempts; i++) {
            randomValue = random.nextInt(maxRandomValue);
            System.out.println("Question: " + randomValue);

            System.out.print("Your answer: ");
            userAnswer = scanner.nextLine();

            correctAnswer = isEven(randomValue) ? "yes" : "no";

            if (userAnswer.toLowerCase().equals(correctAnswer)) {
                numberOfCorrectAnswers++;
                System.out.println("Correct!");
            }
            else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + Cli.getUserName());
                break;
            }
        }

        if (numberOfCorrectAnswers == numberOfAttempts) {
            System.out.println("Congratulations, " + Cli.getUserName());
        }
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
    }
}
