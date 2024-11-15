import java.awt.Graphics2D;

/**
 * CompositeShape interface.
 *
 * This interface defines the methods for shapes that can be drawn and moved.
 *
 * Programmed by: Nathan Dinh
 * Date: 11/14/2024
 */
public interface CompositeShape {

    /**
     * Draws the shape using the specified graphics context.
     *
     * @param g2 the graphics context used for drawing the shape
     */
    void draw(Graphics2D g2);

    /**
     * Moves the shape to a new position.
     * The specific movement behavior is defined by the implementing class.
     */
    void move();
}
