package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        String userChoise;

        Engine.printGameVariants();

        System.out.print("Your choice: ");
        userChoise = sc.nextLine();

        Engine.startGame(userChoise);
    }
}
