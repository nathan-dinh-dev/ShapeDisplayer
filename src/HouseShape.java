import java.awt.*;
import java.awt.geom.*;

/**
 * A house shape that can be drawn and moved.
 * This shape consists of a main rectangular body, a triangular roof,
 * a rectangular door, and two square windows.
 *
 * Programmed by: Nathan Dinh
 * Date: 11/14/2024
 */
public class HouseShape implements CompositeShape {

    private int x;
    private int y;
    private int size;

    /**
     * Constructs a house shape at the specified position with the given size.
     *
     * @param x the x-coordinate of the top-left corner of the house
     * @param y the y-coordinate of the top-left corner of the house
     * @param size the overall size of the house
     */
    public HouseShape(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    /**
     * Moves the house shape one unit to the right.
     */
    public void move() {
        x++;
    }

    /**
     * Draws the house shape using the specified graphics context.
     *
     * @param g2 the graphics context used for drawing the house
     */
    public void draw(Graphics2D g2) {
        // Main part of the house (rectangle)
        Rectangle2D.Double mainHouse = new Rectangle2D.Double(x, y + size / 3, size, size / 2);

        // Roof of the house (triangle)
        Polygon roof = new Polygon(
                new int[]{x, x + size / 2, x + size},
                new int[]{y + size / 3, y, y + size / 3},
                3
        );

        // Door (rectangle)
        Rectangle2D.Double door = new Rectangle2D.Double(x + size / 2 - size / 10, y + size / 2, size / 5, size / 4);

        // Windows (two squares)
        Rectangle2D.Double leftWindow = new Rectangle2D.Double(x + size / 8, y + size / 3 + size / 8, size / 5, size / 5);
        Rectangle2D.Double rightWindow = new Rectangle2D.Double(x + size * 5 / 8 + size / 10, y + size / 3 + size / 8, size / 5, size / 5);

        // Draw all parts
        g2.draw(mainHouse);
        g2.draw(roof);
        g2.draw(door);
        g2.draw(leftWindow);
        g2.draw(rightWindow);
    }
}
