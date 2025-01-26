package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nPlease enter the game number and press Enter."
                + "\n1 - Greet"
                + "\n2 - Even"
                + "\n3 - Calc"
                + "\n4 - GCD"
                + "\n5 - Progression"
                + "\n6 - Prime"
                + "\n0 - Exit");

        System.out.print("Your choice: ");
        String userChoise = sc.nextLine();

        startGame(userChoise);
    }

    public static void startGame(String choise) {
        switch (choise) {
            case ("1"):
                Engine.sayHello();
                break;
            case ("2"):
                Even.run();
                break;
            case ("3"):
                Calc.run();
                break;
            case ("4"):
                GCD.run();
                break;
            case ("5"):
                Progression.run();
                break;
            case ("6"):
                Prime.run();
                break;
            case ("0"):
            default:
                break;
        }
    }

}
