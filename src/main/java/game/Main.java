package game;

import engine.Game;
import engine.GameEngine;
import game.pages.Home;
import game.pages.Loading;
import game.pages.Pages;

public class Main {

    public static void main(String[] args) {
        Game game = GameEngine.getGame();

        game.registerAbstractGamePage(new Loading(game));
        game.registerAbstractGamePage(new Home(game));

        game.setCurrentPage(Pages.LOADING);
    }

}
