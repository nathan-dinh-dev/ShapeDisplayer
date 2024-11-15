import java.awt.*;
import javax.swing.*;

public class ShapeIcon implements Icon {
    private CompositeShape shape;
    private int width, height;

    public ShapeIcon(CompositeShape shape, int width, int height) {
        this.shape = shape;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getIconWidth() { return width; }
    @Override
    public int getIconHeight() { return height; }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        shape.draw(g2);
    }
}
