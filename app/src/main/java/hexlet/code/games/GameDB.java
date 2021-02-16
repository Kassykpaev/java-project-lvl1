package hexlet.code.games;

import java.util.ArrayList;

public class GameDB {
    public static ArrayList<Game> getAllGames() {
        ArrayList<Game> listOfGames = new ArrayList<>();

        listOfGames.add(new Greet());
        listOfGames.add(new Even());
        listOfGames.add(new Calc());
        listOfGames.add(new GCD());

        return listOfGames;
    }
}
