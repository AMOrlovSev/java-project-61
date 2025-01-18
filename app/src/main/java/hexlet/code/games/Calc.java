package hexlet.code.games;

import hexlet.code.Cli;

import java.util.Random;

public class Calc {
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;

    private static final int MAX_VALUE = 100;
    private static int randomValue1;
    private static int randomValue2;

    private static final int TOTAL_OPERATIONS = 3;
    private static int randomOperation;
    private static String operator;

    private static String question;
    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();

    public static void playGame() {
        Cli.sayHello();

        numberOfCorrectAnswers = 0;

        Engine.sayTask("What is the result of the expression?");

        for (int i = 0; i < numberOfAttempts; i++) {
            randomValue1 = random.nextInt(MAX_VALUE);
            randomValue2 = random.nextInt(MAX_VALUE);

            randomOperation = random.nextInt(TOTAL_OPERATIONS);
            operator = operation(randomOperation);

            question = randomValue1 + " " + operator + " " + randomValue2;
            Engine.sayQuestion(question);

            userAnswer = Engine.askAnswer();

            correctAnswer = String.valueOf(resultOperation(randomValue1, randomValue2, operator));

            if (Engine.isCorrect(userAnswer, correctAnswer)) {
                numberOfCorrectAnswers++;
            } else {
                break;
            }
        }

        Engine.gameResult(numberOfCorrectAnswers, numberOfAttempts);
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

    private static int resultOperation(int num1, int num2, String operationSign) {
        switch (operationSign) {
            case ("-"):
                return num1 - num2;
            case ("*"):
                return num1 * num2;
            case ("+"):
            default:
                return num1 + num2;
        }
    }
}
