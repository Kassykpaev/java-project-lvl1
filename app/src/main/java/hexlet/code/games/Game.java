package hexlet.code.games;

public interface Game {
    void start(String gamerName) throws Exception;

    String getName() throws Exception;
}
