package hexlet.code.games;


public class Greet implements Game {
    private static final String GAME_NAME = "Greet";

//    private String playerName;

    @SuppressWarnings("DesignForExtension")
    @Override
    public String getName() {
        return GAME_NAME;
    }

    @SuppressWarnings("DesignForExtension")
    @Override
    public void start(final String gamerName) { }

}
