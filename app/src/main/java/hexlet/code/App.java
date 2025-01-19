package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        String userChoise;

        System.out.println(Engine.getGameVariants());

        System.out.print("Your choice: ");
        userChoise = sc.nextLine();

        Engine.startGame(userChoise);
    }
}
