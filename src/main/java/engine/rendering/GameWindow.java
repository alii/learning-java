package engine.rendering;

import engine.Game;
import engine.GameEngine;
import engine.components.Component;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class GameWindow extends JFrame implements Trackable {

    private final GameRenderer gameRenderer = new GameRenderer();

    private final int id;

    public GameWindow(int id) {
        super(Game.NAME);

        this.id = id;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);

        this.setSize(1280, 720);
        this.registerListeners();
        this.add(gameRenderer);

        this.setLocationRelativeTo(null);
    }

    private void registerListeners() {
        this.addMouseListener(new GameWindowMouseListener());
    }

    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isTrackedBy(ObjectTracker<?, ?> tracker) {
        return tracker.getTracked().contains(this);
    }


    private static class GameWindowMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            List<Component> components = GameEngine.getGame().getCurrentPage().getComponents();

            components.stream().filter(component -> component.isPositionIn(x, y)).forEach(Component::click);
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }
}
