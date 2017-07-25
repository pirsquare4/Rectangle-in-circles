//package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Q3_Circular implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Q3_Circular());
    }

    private static final int DRAWING_WIDTH = 300;
    private static final int DRAWING_HEIGHT = DRAWING_WIDTH;

    private DrawingRectangle drawingRectangle;

    public Q3_Circular() {
        int center = DRAWING_WIDTH / 2;
        Rectangle2D rectangle = new Rectangle2D.Double(center, center, 32D, 32D);
        drawingRectangle = new DrawingRectangle(Color.RED, rectangle);
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Animated Square");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel(DRAWING_WIDTH,
                DRAWING_HEIGHT, drawingRectangle);
        frame.add(drawingPanel);

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        new Thread(new DrawingAnimation(drawingPanel, drawingRectangle))
                .start();
    }

}
