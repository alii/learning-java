package engine.components;

import engine.rendering.Interactable;

import java.util.UUID;

public abstract class Component implements Renderable, Interactable {

    private int x, y, width, height;

    private final UUID uuid = UUID.randomUUID();

    public Component(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void click() {}

    @Override
    public void keypress() {}

    public boolean isPositionIn(int x, int y) {
        // TODO: Simplify this
        boolean afterX = x > this.getX();
        boolean afterY = y > this.getY();
        boolean beforeMaxX = x < this.getX() + this.getWidth();
        boolean beforeMaxY = y < this.getY() + this.getHeight();

        return afterX && afterY && beforeMaxY && beforeMaxX;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
