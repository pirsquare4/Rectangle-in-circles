import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class DrawingAnimation implements Runnable {

    private DrawingPanel drawingPanel;

    private DrawingRectangle drawingRectangle;

    public DrawingAnimation(DrawingPanel drawingPanel,
            DrawingRectangle drawingRectangle) {
        this.drawingPanel = drawingPanel;
        this.drawingRectangle = drawingRectangle;
    }

    @Override
    public void run() {
        int xCenter = drawingPanel.getWidth() / 2;
        int yCenter = drawingPanel.getHeight() / 2;
        double radius = drawingPanel.getWidth() / 3;
        while (true){
          for (int degree = 0; degree < 360; degree++) {
              double radians = Math.toRadians((double) degree);
              double x = radius * Math.cos(radians) + xCenter;
              double y = radius * Math.sin(radians) + yCenter;
              drawingRectangle.setRectangleOrigin(x, y);
              repaint();
              sleep(25L);
        }
      }
    }

    private void sleep(long interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {

        }
    }

    private void repaint() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                drawingPanel.repaint();
            }
        });
    }
}
