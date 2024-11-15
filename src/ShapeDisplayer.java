import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ShapeDisplayer sets up a simple GUI application that allows users to choose
 * and display different shapes (Car, Snowman, Custom House) on a drawing panel.
 *
 * Programmed by: Nathan Dinh
 * Date: 11/14/2024
 */
public class ShapeDisplayer {
    private CompositeShape currentShape;
    // Variable to check which button is selected
    private JButton selectedButton;
    // List to store drawn shapes
    private List<CompositeShape> shapesList = new ArrayList<>();

    /**
     * The main method initializes the GUI application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeDisplayer().createAndShowGUI());
    }

    /**
     * Creates and displays the main application window with buttons for each shape
     * and a drawing panel. Shapes can be selected from the buttons and drawn by
     * clicking on the panel.
     */
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Shape Displayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        // Create and add buttons for each shape
        JButton carButton = createButton(new CarShape(0, 0, 50), "Car");
        JButton snowmanButton = createButton(new SnowMan(0, 0, 50), "Snowman");
        JButton houseButton = createButton(new HouseShape(0, 0, 50), "House");

        buttonPanel.add(carButton);
        buttonPanel.add(snowmanButton);
        buttonPanel.add(houseButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Redraw all shapes from the list whenever the panel repaints
                for (CompositeShape shape : shapesList) {
                    shape.draw((Graphics2D) g);
                }
            }
        };

        // Add a mouse listener to the drawing panel
        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (currentShape != null) {
                    // Create a new instance of the current shape at the mouse location
                    CompositeShape shapeToDraw = getNewShapeInstance(currentShape, e.getX(), e.getY(), 50);
                    shapesList.add(shapeToDraw); // Add shape to the list
                    drawingPanel.repaint(); // Repaint to display the new shape
                }
            }
        });

        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    /**
     * Creates a button with a specified shape icon and label. When clicked,
     * this button sets the shape as the current shape to be drawn.
     *
     * @param shape the shape that the button represents
     * @param name the name to be displayed on the button
     * @return the configured JButton instance
     */
    private JButton createButton(CompositeShape shape, String name) {
        JButton button = new JButton(new ShapeIcon(shape, 50, 50));
        button.setText(name);

        // Add action listener to change the selected button and shape
        button.addActionListener(e -> {
            currentShape = shape;
            updateButtonSelection(button);
        });

        return button;
    }

    /**
     * Updates the appearance of the selected button, and resets the previously selected button.
     *
     * @param button the newly selected button
     */
    private void updateButtonSelection(JButton button) {
        // Reset the background of the previously selected button
        if (selectedButton != null) {
            selectedButton.setBorder(BorderFactory.createEmptyBorder());
        }

        // Set the border of the newly selected button
        button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

        // Update the reference to the selected button
        selectedButton = button;
    }

    /**
     * Returns a new instance of the specified shape at a given position with a
     * specified size.
     *
     * @param shape the shape to instantiate
     * @param x the x-coordinate for the new shape's position
     * @param y the y-coordinate for the new shape's position
     * @param size the size for the new shape
     * @return a new instance of the specified CompositeShape
     */
    private CompositeShape getNewShapeInstance(CompositeShape shape, int x, int y, int size) {
        if (shape instanceof CarShape) {
            return new CarShape(x, y, size);
        } else if (shape instanceof SnowMan) {
            return new SnowMan(x, y, size);
        } else if (shape instanceof HouseShape) {
            return new HouseShape(x, y, size);
        }
        return null;
    }
}
