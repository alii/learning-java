package engine.physics;

import engine.Game;
import engine.GameEngine;
import engine.rendering.GameRenderer;

public class RenderLoop implements Runnable {

    @Override
    public void run() {
        GameRenderer renderer = GameEngine.getGame().getGameWindow().getGameRenderer();

        while (true) {
            renderer.repaint();

            try {
                Thread.sleep(1000 / Game.FPS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
