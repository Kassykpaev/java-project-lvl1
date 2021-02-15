package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.print("May I Have your name? ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(String.format("Hello, %s!", str));
    }
}