package engine;

import engine.physics.RenderLoop;
import engine.rendering.AbstractGamePage;
import engine.rendering.GameWindow;
import game.pages.Pages;

import java.util.HashMap;
import java.util.Random;

public class Game {

    public static final String NAME = "ballf";
    public static final int FPS = 60;

    public static final Random random = new Random();

    public static int WIDTH = 1280, HEIGHT = 720;

    private AbstractGamePage currentPage;

    private final HashMap<Pages, AbstractGamePage> cachedAbstractGamePages = new HashMap<>();
    private final GameWindow gameWindow = new GameWindow();
    private final Thread gameRenderThread = new Thread(new RenderLoop());

    Game() {
        this.currentPage = null;
        this.gameRenderThread.start();
    }

    public void setCurrentPage(Pages id) {
        currentPage = this.cachedAbstractGamePages.get(id);
    }

    public void registerAbstractGamePage(AbstractGamePage gamePage) {
        cachedAbstractGamePages.put(gamePage.getId(), gamePage);
    }

    public boolean isCurrentAbstractPageDefined() {
        return currentPage != null;
    }

    public AbstractGamePage getCurrentPage() {
        return currentPage;
    }

    public void removeAbstractGamePage(Pages id) {
        cachedAbstractGamePages.remove(id);
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }
}
