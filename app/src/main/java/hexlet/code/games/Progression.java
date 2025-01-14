package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Random;

public class Progression {
    private static int numberOfCorrectAnswers = 0;
    private static int numberOfAttempts = Engine.TOTAL_ATTEMP;

    private static int totalNumbers = 10;
    private static String[] progression;
    private static int unknownRandomValue;

    private static int maxRandomValue = 10;
    private static int randomValue1;

    private static int maxStep = 10;
    private static int minStep = 2;
    private static int randomStep;

    private static String question;
    private static String userAnswer;
    private static String correctAnswer;

    private static Random random = new Random();

    public static void playGame() {
        Cli.sayHello();

        numberOfCorrectAnswers = 0;

        Engine.sayTask("What number is missing in the progression?");

        for (int i = 0; i < numberOfAttempts; i++) {
            randomValue1 = random.nextInt(maxRandomValue);
            randomStep = minStep + (int) (Math.random() * ((maxStep - minStep) + 1));

            progression = createProgression(totalNumbers, randomValue1, randomStep);

            unknownRandomValue = random.nextInt(totalNumbers);

            var temp = String.valueOf(progression[unknownRandomValue]);

            progression[unknownRandomValue] = "..";

            question = Arrays.toString(progression);
            question = question.replace("[", "").replace("]", "").replace(",", "");
            System.out.println(question);

            Engine.sayQuestion(question);

            userAnswer = Engine.askAnswer();

            correctAnswer = temp;

            if (Engine.isCorrect(userAnswer, correctAnswer)) {
                numberOfCorrectAnswers++;
            } else {
                break;
            }
        }

        Engine.gameResult(numberOfCorrectAnswers, numberOfAttempts);
    }

    private static String[] createProgression(int totalNums, int firstNum, int step) {
        String[] progres = new String[totalNums];
        for (int i = 0; i < totalNums; i++) {
            progres[i] = String.valueOf(firstNum + step * i);
        }
        return progres;
    }

}
