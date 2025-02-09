package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    private static final int MAX_VALUE = 100;
    private static final int TOTAL_OPERATIONS = 3;
    private static final String TASK = "What is the result of the expression?";

    public static void run() {
        String[][] gameData = new String[Engine.TOTAL_ROUNDS][];
        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = generateRoundData();
        }

        Engine.run(TASK, gameData);
    }

    public static String[] generateRoundData() {
        int randomValue1 = Utils.randomNumber(MAX_VALUE);
        int randomValue2 = Utils.randomNumber(MAX_VALUE);

        int randomOperation = Utils.randomNumber(TOTAL_OPERATIONS);
        String operator = operation(randomOperation);

        String[] roundData = new String[Engine.ROUND_ARRAY_LENGTH];
        roundData[Engine.ROUND_QUESTION] = randomValue1 + " " + operator + " " + randomValue2;
        roundData[Engine.ROUND_ANSWER] = String.valueOf(resultOperation(randomValue1, randomValue2, operator));

        return roundData;
    }

    private static String operation(int value) {
        String[] operations = new String[] {"-", "*", "+"};
        return operations[value];
    }

    private static int resultOperation(int num1, int num2, String operationSign) {
        switch (operationSign) {
            case ("-"):
                return num1 - num2;
            case ("*"):
                return num1 * num2;
            case ("+"):
                return num1 + num2;
            default:
                throw new RuntimeException("Incorrect input.");
        }
    }
}
