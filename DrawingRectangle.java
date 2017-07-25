import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class DrawingRectangle {

    private final Color color;

    private Rectangle2D rectangle;

    public DrawingRectangle(Color color, Rectangle2D rectangle) {
        this.color = color;
        this.rectangle = rectangle;
    }

    public void setRectangleOrigin(double x, double y) {
        rectangle
                .setRect(x, y, rectangle.getWidth(), rectangle.getHeight());
    }

    public Color getColor() {
        return color;
    }

    public Rectangle2D getRectangle() {
        return rectangle;
    }

}
