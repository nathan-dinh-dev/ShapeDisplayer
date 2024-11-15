import java.awt.*;
import java.awt.geom.*;

public class HouseShape implements CompositeShape {
    private int x;
    private int y;
    private int size;

    public HouseShape(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void move() {
        x++;
    }

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
