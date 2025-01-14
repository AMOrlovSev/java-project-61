package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class Calc {
    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;
    private static int maxRandomValue = 100;

    private static int randomValue1;
    private static int randomValue2;

    private static int totalOperations = 3;
    private static int randomOperation;
    private static String operator;

    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void playGame() {
        Cli.sayHello();

        int numberOfCorrectAnswers = 0;

        System.out.println("What is the result of the expression?");

        for (int i = 0; i < numberOfAttempts; i++) {
            randomValue1 = random.nextInt(maxRandomValue);
            randomValue2 = random.nextInt(maxRandomValue);

            randomOperation = random.nextInt(totalOperations);
            operator = operation(randomOperation);

            System.out.println("Question: " + randomValue1 + operator + randomValue2);

            System.out.print("Your answer: ");
            userAnswer = scanner.nextLine();

            correctAnswer = String.valueOf(resultOperation(randomValue1, randomValue2, randomOperation));

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

    private static String operation(int value) {
        switch (value) {
            case (1):
                return "-";
            case (2):
                return "*";
            case (0):
            default:
                return "+";
        }
    }

    private static int resultOperation(int num1, int num2, int operation) {
        switch (operation) {
            case (1):
                return num1 - num2;
            case (2):
                return num1 * num2;
            case (0):
            default:
                return num1 + num2;
        }
    }
}
