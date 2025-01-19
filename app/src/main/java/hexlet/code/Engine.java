package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

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
    private static Random random = new Random();

    public static Random getRandom() {
        return random;
    }

    public static void printGameVariants() {
        System.out.println("\nPlease enter the game number and press Enter."
                + "\n1 - Greet"
                + "\n2 - Even"
                + "\n3 - Calc"
                + "\n4 - GCD"
                + "\n5 - Progression"
                + "\n6 - Prime"
                + "\n0 - Exit");
    }

//    public static void printGameVariants() {
//        System.out.println("""
//
//                Please enter the game number and press Enter.
//                1 - Greet
//                2 - Even
//                3 - Calc
//                4 - GCD
//                5 - Progression
//                6 - Prime
//                0 - Exit""");
//    }

    public static void startGame(String choise) {
        switch (choise) {
            case ("1"):
                Engine.sayHello();
                break;
            case ("2"):
                Even.playGame();
                break;
            case ("3"):
                Calc.playGame();
                break;
            case ("4"):
                GCD.playGame();
                break;
            case ("5"):
                Progression.playGame();
                break;
            case ("6"):
                Prime.playGame();
                break;
            case ("0"):
            default:
                break;
        }
    }

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

    private static void sayQuestion(String gameQuestion) {
        System.out.println("Question: " + gameQuestion);
    }

    private static String askAnswer() {
        System.out.print("Your answer: ");
        return sc.nextLine();
    }

    private static boolean isCorrect(String gameUserAnswer, String gameCorrectAnswer) {
        return gameUserAnswer.equalsIgnoreCase(gameCorrectAnswer);
    }

    private static void attemptResult(boolean gCorect, String gUserAnswer, String gCorAnswer) {
        if (gCorect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + gUserAnswer + "' is wrong answer ;(. Correct answer was '" + gCorAnswer + "'.");
        }
    }



    private static void gameResult() {
        finalResult = successfulAttempts == TOTAL_ATTEMP ? "Congratulations, " : "Let's try again, ";
        System.out.println(finalResult + userName + "!");
    }
}
