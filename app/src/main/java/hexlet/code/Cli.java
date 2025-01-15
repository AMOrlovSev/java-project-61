package hexlet.code;

import java.util.Scanner;

public class Cli {

    private static String userName;

    public static String getUserName() {
        return userName;
    }

    public static void sayHello() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = sc.nextLine();

        System.out.println("Hello, " + userName + "!");
    }
}
