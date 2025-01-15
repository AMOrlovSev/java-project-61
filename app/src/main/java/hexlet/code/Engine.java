package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TOTAL_ATTEMP = 3;

    private static Scanner scanner = new Scanner(System.in);

    public static void sayTask(String task) {
        System.out.println(task);
    }

    public static void sayQuestion(String question) {
        System.out.println("Question: " + question);
    }

    public static String askAnswer() {
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    public static boolean isCorrect(String userAnswer, String correctAnswer) {
        if (userAnswer.toLowerCase().equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + Cli.getUserName() + "!");
            return false;
        }
    }

    public static void gameResult(int numberOfCorrectAnswers, int numberOfAttempts) {
        if (numberOfCorrectAnswers == numberOfAttempts) {
            System.out.println("Congratulations, " + Cli.getUserName() + "!");
        }
    }
}
