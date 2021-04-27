package engine;

import engine.physics.RenderLoop;
import engine.rendering.AbstractGamePage;
import engine.rendering.GameWindow;
import game.pages.Pages;

import java.util.HashMap;
import java.util.Random;

public class Game {

    public static final String NAME = "Game";
    public static final int FPS = 60;

    public static final Random random = new Random();

    public static int WIDTH = 1280, HEIGHT = 720;

    private AbstractGamePage currentPage;

    private final HashMap<Pages, AbstractGamePage> cachedAbstractGamePages;
    private final GameWindow gameWindow;

    Game(GameWindow window) {
        this.currentPage = null;

        this.gameWindow = window;
        cachedAbstractGamePages = new HashMap<>();

        RenderLoop renderLoop = new RenderLoop();
        Thread gameRenderThread = new Thread(renderLoop);

        gameRenderThread.start();
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
