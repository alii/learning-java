package engine;

public class GameEngine {

    private static Game game = null;

    public static Game getGame() {
        if (game == null) {
            game = new Game();
        }

        return game;
    }
}
