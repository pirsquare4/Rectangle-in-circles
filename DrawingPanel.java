import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = 8226587438110549806L;

    private DrawingRectangle drawingRectangle;

    public DrawingPanel(int width, int height,
            DrawingRectangle drawingRectangle) {
        this.setPreferredSize(new Dimension(width, height));
        this.drawingRectangle = drawingRectangle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(drawingRectangle.getColor());

        Rectangle2D rectangle = drawingRectangle.getRectangle();
        int x = (int) Math.round(rectangle.getX());
        int y = (int) Math.round(rectangle.getY());
        int width = (int) Math.round(rectangle.getWidth());
        int height = (int) Math.round(rectangle.getHeight());
        g.fillRect(x - width / 2, y - height / 2, width, height);
    }

}
