package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter."
                + "\n1 - Greet"
                + "\n2 - Even"
                + "\n0 - Exit");
        System.out.print("Your choice: ");
        var userChoise = sc.nextInt();
        sc.nextLine();


        switch (userChoise) {
            case (1):
//                Cli.sayHello();
                break;
            case (2):
                Even.playGame();
                break;
            case (0):
            default:
                break;
        }

    }
}
