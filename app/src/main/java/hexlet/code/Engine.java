package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {

    private static String userName;

    private static int successfulAttempts;
    public static final int TOTAL_ATTEMP = 3;

    public static final int GAME_QA = 2;
    public static final int GAME_Q = 0;
    public static final int GAME_A = 1;

    private static String question;
    private static String userAnswer;
    private static String correctAnswer;
    private static boolean corect;

    private static String finalResult;

    private static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void playGame(String task, String[][] game) {
        successfulAttempts = 0;

        sayHello();
        sayTask(task);

        playGame(game);

        gameResult();
    }

    public static void sayHello() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = sc.nextLine();

        System.out.println("Hello, " + userName + "!");
    }

    private static void sayTask(String task) {
        System.out.println(task);
    }



    private static void playGame(String[][] gameQustionAnswer) {
        for (int i = 0; i < TOTAL_ATTEMP; i++) {

            question = (gameQustionAnswer[i][GAME_Q]);
            sayQuestion(question);

            userAnswer = askAnswer();
            correctAnswer = (gameQustionAnswer[i][GAME_A]);
            corect = isCorrect(userAnswer, correctAnswer);

            attemptResult(corect, userAnswer, correctAnswer);

            if (corect) {
                successfulAttempts++;
            } else {
                break;
            }
        }
    }

    private static void sayQuestion(String question) {
        System.out.println("Question: " + question);
    }

    private static String askAnswer() {
        System.out.print("Your answer: ");
        return sc.nextLine();
    }

    private static boolean isCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }

    private static void attemptResult(boolean corect, String userAnswer, String correctAnswer) {
        if (corect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        }
    }



    private static void gameResult() {
        finalResult = successfulAttempts == TOTAL_ATTEMP ? "Congratulations, " : "Let's try again, ";
        System.out.println(finalResult + userName + "!");
    }
}
