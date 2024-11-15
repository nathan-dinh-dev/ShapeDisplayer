import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeDisplayer {
    private CompositeShape currentShape;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeDisplayer().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Shape Displayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        // Create and add buttons for each shape
        JButton carButton = createButton(new CarShape(0, 0, 50), "Car");
        JButton snowmanButton = createButton(new SnowMan(0, 0, 50), "Snowman");
        JButton customShapeButton = createButton(new HouseShape(0, 0, 50), "Custom");

        buttonPanel.add(carButton);
        buttonPanel.add(snowmanButton);
        buttonPanel.add(customShapeButton);

        frame.add(buttonPanel, BorderLayout.NORTH);

        JPanel drawingPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };

        // Add a mouse listener to the drawing panel
        drawingPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (currentShape != null) {
                    CompositeShape shapeToDraw = getNewShapeInstance(currentShape, e.getX(), e.getY(), 50);
                    shapeToDraw.draw((Graphics2D) drawingPanel.getGraphics());
                }
            }
        });

        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JButton createButton(CompositeShape shape, String name) {
        JButton button = new JButton(new ShapeIcon(shape, 50, 50));
        button.addActionListener(e -> currentShape = shape);
        button.setText(name);
        return button;
    }

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
