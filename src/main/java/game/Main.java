package game;

import engine.Game;
import engine.GameEngine;
import engine.rendering.GameWindow;
import engine.rendering.ObjectTracker;
import game.pages.Home;
import game.pages.Loading;
import game.pages.Pages;

public class Main {

    public static void main(String[] args) {
        final Game game = GameEngine.getGame();
        final ObjectTracker<Game, GameWindow> tracker = new ObjectTracker<>(game);

        tracker.addTrackable(game.getGameWindow());
        tracker.getTrackedItem(0).setVisible(true);

        game.registerAbstractGamePage(new Loading(game));
        game.registerAbstractGamePage(new Home(game));

        game.setCurrentPage(Pages.LOADING);
    }
}
