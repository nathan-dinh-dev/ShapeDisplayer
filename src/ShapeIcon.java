import java.awt.*;
import javax.swing.*;

/**
 * ShapeIcon is an implementation of the Icon interface that adapts a
 * CompositeShape to be used as an icon in a Swing component.
 *
 * Programmed by: Nathan Dinh
 * Date: 11/14/2024
 */
public class ShapeIcon implements Icon {
    private CompositeShape shape;
    private int width, height;

    /**
     * Constructs a ShapeIcon with a specified shape, width, and height.
     *
     * @param shape the CompositeShape to be displayed as an icon
     * @param width the width of the icon
     * @param height the height of the icon
     */
    public ShapeIcon(CompositeShape shape, int width, int height) {
        this.shape = shape;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the width of the icon.
     *
     * @return the width of the icon
     */
    @Override
    public int getIconWidth() {
        return width;
    }

    /**
     * Returns the height of the icon.
     *
     * @return the height of the icon
     */
    @Override
    public int getIconHeight() {
        return height;
    }

    /**
     * Paints the icon by drawing the associated shape within the graphics context.
     *
     * @param c the component to which the icon is added
     * @param g the graphics context for painting
     * @param x the x-coordinate of the icon's top-left corner
     * @param y the y-coordinate of the icon's top-left corner
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(x, y); // Move the graphics context to the icon's position
        shape.draw(g2); // Draw the shape
        g2.translate(-x, -y); // Reset the graphics context position
    }
}
