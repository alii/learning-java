package game.pages;

import engine.Game;
import engine.rendering.AbstractGamePage;

import java.awt.*;

public class Home extends AbstractGamePage {

    public Home(Game game) {
        super(game, Pages.HOME);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(new Color(Game.random.nextFloat(), Game.random.nextFloat(), Game.random.nextFloat()));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.drawString("ppppp", 0, 0);
    }

}
