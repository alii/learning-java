package engine;

import engine.rendering.GameWindow;

public class GameEngine {

    private static Game game = null;

    public static Game getGame() {
        if (game == null) {
            game = new Game(new GameWindow(0));
        }
        return game;
    }

}
