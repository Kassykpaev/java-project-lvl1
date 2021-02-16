package hexlet.code.games;


public class Greet implements Game {
    private static final String GAME_NAME = "Greet";

//    private String gamerName;

    @Override
    public String getName() {
        return GAME_NAME;
    }

    @Override
    public void start(final String gamerName) { }

    @Override
    public String session() {
        return null;
    }
}
