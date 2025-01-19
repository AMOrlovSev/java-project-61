package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    private static String task = "What is the result of the expression?";

    private static String[][] gameQustionAnswer;
    private static String question;
    private static String correctAnswer;

    private static final int MAX_VALUE = 100;
    private static int randomValue1;
    private static int randomValue2;

    private static final int TOTAL_OPERATIONS = 3;
    private static int randomOperation;
    private static String operator;

    private static Random random = Engine.getRandom();

    public static void playGame() {
        gameQustionAnswer = fillQuestionAnswer();
        Engine.playGame(task, gameQustionAnswer);
    }

    private static String[][] fillQuestionAnswer() {
        gameQustionAnswer = new String[Engine.TOTAL_ATTEMP][Engine.GAME_QA];
        for (int i = 0; i < Engine.TOTAL_ATTEMP; i++) {
            randomValue1 = random.nextInt(MAX_VALUE);
            randomValue2 = random.nextInt(MAX_VALUE);

            randomOperation = random.nextInt(TOTAL_OPERATIONS);
            operator = operation(randomOperation);

            question = randomValue1 + " " + operator + " " + randomValue2;
            correctAnswer = String.valueOf(resultOperation(randomValue1, randomValue2, operator));

            gameQustionAnswer[i][Engine.GAME_Q] = question;
            gameQustionAnswer[i][Engine.GAME_A] = correctAnswer;
        }
        return gameQustionAnswer;
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
