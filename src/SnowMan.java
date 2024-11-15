import java.awt.*;
import java.awt.geom.*;

public class SnowMan implements CompositeShape {
    private int x;
    private int y;
    private int size;

    public SnowMan(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void move() {
        x++;
    }

    public void draw(Graphics2D g2) {
        // Body circle
        Ellipse2D.Double bodyCircle = new Ellipse2D.Double(x, y + size / 2, size, size);

        // Head circle (same width and height as body)
        Ellipse2D.Double headCircle = new Ellipse2D.Double(x + size / 4, y, size / 2, size / 2);

        g2.draw(bodyCircle);
        g2.draw(headCircle);
    }
}
