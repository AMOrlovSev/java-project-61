package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void playGame() {
        Cli user = new Cli();

        user.sayHello();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int numberOfCorrectAnswer = 0;
        int numberOfAttempts = 3;
        int maxRandomValue = 1000;
        int randomValue;

        String userAnswer;
        String correctAnswer;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numberOfAttempts; i++) {
            randomValue = random.nextInt(maxRandomValue);
            System.out.println("Question: " + randomValue);

            System.out.print("Your answer: ");
            userAnswer = scanner.nextLine();

            correctAnswer = randomValue % 2 == 0 ? "yes" : "no";

            if (userAnswer.toLowerCase().equals(correctAnswer)) {
                numberOfCorrectAnswer++;
                System.out.println("Correct!");
            }
            else {
                System.out.println("'%s' is wrong answer ;(. Correct answer was '%s'.".formatted(userAnswer, correctAnswer));
                System.out.println("Let's try again, " + user.getUserName());
                break;
            }
        }

        if (numberOfCorrectAnswer == numberOfAttempts) {
            System.out.println("Congratulations, " + user.getUserName());
        }

    }


}
