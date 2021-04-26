package engine.rendering;

import engine.Game;
import engine.components.Component;
import engine.components.Renderable;
import game.pages.Pages;

import java.awt.*;
import java.util.ArrayList;

public abstract class AbstractGamePage implements Renderable {

    private final Pages id;
    private final ArrayList<Component> components;
    protected Game game;

    public AbstractGamePage(Game game, Pages id) {
        this.game = game;
        this.id = id;
        this.components = new ArrayList<>();
    }

    public ArrayList<Component> getComponents() {
        return components;
    }

    protected void registerComponent(Component component) {
        this.components.add(component);
    }

    public abstract void paint(Graphics g);

    public Pages getId() {
        return id;
    }
}
