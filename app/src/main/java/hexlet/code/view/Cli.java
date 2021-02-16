package hexlet.code.view;

//import com.company.games.Game;
//import com.company.games.GameDB;
import hexlet.code.games.Game;
import hexlet.code.games.GameDB;

import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.Scanner;


public class Cli {
    private static Scanner sc = new Scanner(System.in);
    private static final ArrayList<Game> LIST_OF_GAMES = GameDB.getAllGames();

    public static void showMenu() throws Exception {
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 0; i < LIST_OF_GAMES.size(); i++) {
            System.out.println(String.format("%d - %s",
                    i + 1,
                    LIST_OF_GAMES.get(i).getName()));
        }
        System.out.println("0 - Exit");
        boolean fl = false;
        String gameNumber = "";
        int i = 0;
        do {
            System.out.print("Your choice: ");
            gameNumber = sc.next();
            if (isNumeric(gameNumber)
                    && Integer.parseInt(gameNumber) > -1
                    && Integer.parseInt(gameNumber) <= LIST_OF_GAMES.size()) {
                i = Integer.parseInt(gameNumber);
                fl = true;
            } else {
                System.out.println("You inputed bad value");
            }
        } while (!fl);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I Have your name? ");
        String str = sc.next();
        System.out.println(String.format("Hello, %s!", str));

        startGame(i - 1, str);
    }

    public static void startGame(final int gameToStart,
                                 final String gamerName) throws Exception {
        LIST_OF_GAMES.get(gameToStart).start(gamerName);
    }

    public static String getLine() {
        String str = sc.next();
        return str;
    }

    private static boolean isNumeric(final String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
