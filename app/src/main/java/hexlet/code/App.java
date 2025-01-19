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

        printGameVariants();

        System.out.print("Your choice: ");
        userChoise = sc.nextLine();

        startGame(userChoise);
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

}
