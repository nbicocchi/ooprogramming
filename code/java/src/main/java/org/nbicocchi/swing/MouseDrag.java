package org.nbicocchi.swing;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseDrag extends JFrame {
    private static final long serialVersionUID = 1L;
    int startX, startY, endX, endY;

    private class DrawPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // draw background
            g.setColor(Color.RED);
            g.drawRect(startX, startY, endX - startX + 1, endY - startY + 1);
        }
    }

    private class MyListener extends MouseInputAdapter {
        @Override
        public void mousePressed(MouseEvent evt) {
            startX = evt.getX();
            startY = evt.getY();
        }

        @Override
        public void mouseDragged(MouseEvent evt) {
            endX = evt.getX();
            endY = evt.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent evt) {
            endX = evt.getX();
            endY = evt.getY();
            repaint();
        }
    }

    public MouseDrag() {
        DrawPanel drawPanel = new DrawPanel();
        MyListener listener = new MyListener();
        drawPanel.addMouseListener(listener);
        drawPanel.addMouseMotionListener(listener);

        setContentPane(drawPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setTitle("Mouse Drag");
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MouseDrag::new);
    }
}