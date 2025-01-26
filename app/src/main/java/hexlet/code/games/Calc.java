package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static String task = "What is the result of the expression?";
    private static final int MAX_VALUE = 100;
    private static final int TOTAL_OPERATIONS = 3;

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ATTEMPTS][Engine.ROUND_ARRAY_LENGTH];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(task, gameData);
    }

    public static String[] generateRoundData() {
        int randomValue1 = Utils.getRandom(MAX_VALUE);
        int randomValue2 = Utils.getRandom(MAX_VALUE);

        int randomOperation = Utils.getRandom(TOTAL_OPERATIONS);
        String operator = operation(randomOperation);

        String question = randomValue1 + " " + operator + " " + randomValue2;
        String correctAnswer = String.valueOf(resultOperation(randomValue1, randomValue2, operator));

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_POS_Q] = question;
        roundData[Engine.ROUND_POS_A] = correctAnswer;

        return roundData;
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
