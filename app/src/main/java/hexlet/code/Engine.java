package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int TOTAL_ROUNDS = 3;

    public static final int ROUND_ARRAY_LENGTH = 2;
    public static final int ROUND_QUESTION = 0;
    public static final int ROUND_ANSWER = 1;

    private static Scanner sc = new Scanner(System.in);

    public static void run(String task, String[][] game) {
        Cli.sayHello();

        System.out.println(task);

        for (int i = 0; i < TOTAL_ROUNDS; i++) {
            String question = (game[i][ROUND_QUESTION]);
            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();

            String correctAnswer = (game[i][ROUND_ANSWER]);
            boolean correct = userAnswer.equalsIgnoreCase(correctAnswer);

            if (correct) {
                System.out.println("Correct!");
            } else {
                System.out.print("'" + userAnswer + "' is wrong answer ;(. ");
                System.out.println("Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + Cli.getUserName() + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + Cli.getUserName() + "!");
    }
}
