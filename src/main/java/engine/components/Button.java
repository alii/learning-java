package engine.components;

import java.awt.*;

public class Button extends Component {
    private String label;
    private ButtonClickHandler clickHandler;

    public Button(int x, int y, int width, int height, String label) {
        super(x, y, width, height);
        this.label = label;
        this.clickHandler = null;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void click() {
        if (this.clickHandler != null) {
            this.clickHandler.click();
        }
    }

    public void setClickHandler(ButtonClickHandler handler) {
        this.clickHandler = handler;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());

        g.setColor(Color.WHITE);
        g.drawString(this.label, this.getX(), this.getY());
    }

    public interface ButtonClickHandler {
        void click();
    }
}
