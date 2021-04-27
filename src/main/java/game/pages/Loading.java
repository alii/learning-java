package game.pages;

import engine.Game;
import engine.GameEngine;
import engine.components.Button;
import engine.rendering.AbstractGamePage;

import java.awt.*;

public class Loading extends AbstractGamePage {

    private final Button playButton;

    public Loading(final Game game) {
        super(game, Pages.LOADING);

        this.playButton = new Button(10, 20, 40, 20, "dez nutys");
        this.registerComponent(playButton);

        this.playButton.setClickHandler(() -> GameEngine.getGame().setCurrentPage(Pages.HOME));
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.drawString("ballf game real (rael official)", 200, 200);

        this.playButton.paint(g);
    }

}
