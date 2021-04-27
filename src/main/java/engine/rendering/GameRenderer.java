package engine.rendering;

import engine.Game;
import engine.GameEngine;

import javax.swing.*;
import java.awt.*;

public class GameRenderer extends JPanel {

    @Override
    public synchronized void paint(Graphics g) {
        Game currentGame = GameEngine.getGame();

        if (currentGame.isCurrentAbstractPageDefined()) {
            currentGame.getCurrentPage().paint(g);
        }
    }

}
