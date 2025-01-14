package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String userChoise;
        do {
            System.out.println("\nPlease enter the game number and press Enter."
                    + "\n1 - Greet"
                    + "\n2 - Even"
                    + "\n3 - Calc"
                    + "\n4 - GCD"
                    + "\n0 - Exit");
            System.out.print("Your choice: ");
            userChoise = sc.nextLine();

            switch (userChoise) {
                case ("1"):
                    Cli.sayHello();
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
                case ("0"):
                default:
                    break;
            }
        }
        while (!userChoise.equals("0"));


    }
}
