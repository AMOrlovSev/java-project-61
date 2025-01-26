package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TOTAL_ATTEMPTS = 3;

    public static final int ROUND_ARRAY_LENGTH = 2;
    public static final int ROUND_POS_Q = 0;
    public static final int ROUND_POS_A = 1;

    private static String userName = "User Name";
    private static Scanner sc = new Scanner(System.in);

    public static void run(String task, String[][] game) {
        sayHello();

        System.out.println(task);

        for (int i = 0; i < TOTAL_ATTEMPTS; i++) {
            String question = (game[i][ROUND_POS_Q]);
            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            String correctAnswer = (game[i][ROUND_POS_A]);
            boolean correct = userAnswer.equalsIgnoreCase(correctAnswer);

            if (correct) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + userAnswer + "' is wrong answer ;(.");
                System.out.println("Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + userName + "!");
    }

    public static void sayHello() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = sc.nextLine();

        System.out.println("Hello, " + userName + "!");
    }
}
