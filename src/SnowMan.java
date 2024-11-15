import java.awt.*;
import java.awt.geom.*;

/**
 * A simple snowman shape that can be drawn and moved.
 * This shape consists of two circles: one for the body and one for the head.
 *
 * Programmed by: Nathan Dinh
 * Date: 11/14/2024
 */
public class SnowMan implements CompositeShape {
    private int x;
    private int y;
    private int size;

    /**
     * Constructs a SnowMan shape at the specified position with the given size.
     *
     * @param x the x-coordinate of the top-left corner of the snowman
     * @param y the y-coordinate of the top-left corner of the snowman
     * @param size the diameter of the body of the snowman
     */
    public SnowMan(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    /**
     * Moves the snowman shape one unit to the right.
     */
    public void move() {
        x++;
    }

    /**
     * Draws the snowman shape using the specified graphics context.
     *
     * @param g2 the graphics context used for drawing the snowman
     */
    public void draw(Graphics2D g2) {
        // Body circle
        Ellipse2D.Double bodyCircle = new Ellipse2D.Double(x, y + size / 2, size, size);

        // Head circle (same width and height as body)
        Ellipse2D.Double headCircle = new Ellipse2D.Double(x + size / 4, y, size / 2, size / 2);

        // Draw both circles to represent the snowman's body and head
        g2.draw(bodyCircle);
        g2.draw(headCircle);
    }
}
