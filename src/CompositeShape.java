import java.awt.Graphics2D;

/**
 * CompositeShape interface.
 * This interface is borrowed from textbook "Object-Oriented Design and Patterns"
 */

public interface CompositeShape {
    void draw(Graphics2D g2);
    void move();
}
