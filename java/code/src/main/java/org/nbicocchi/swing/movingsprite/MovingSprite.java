package org.nbicocchi.swing.movingsprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Custom Graphics Example: Using key/button to move a object left or right. The
 * moving object (sprite) is defined in its own class, with its own operations
 * and can paint itself.
 */
public class MovingSprite extends JFrame implements KeyListener, ActionListener {
    private static final long serialVersionUID = 1L;
    JButton btnLeft;
    JButton btnRight;
    JButton btnUp;
    JButton btnDown;
    GamePanel p;

    public MovingSprite() {
        super("Moving Sprite");

        // Set up a panel for the game itself
        p = new GamePanel(new Dimension(400, 400), "src/main/resources/images/lock.jpg");

        // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(new FlowLayout());

        btnLeft = new JButton("Move Left ");
        btnLeft.addActionListener(this);
        btnPanel.add(btnLeft);

        btnRight = new JButton("Move Right");
        btnRight.addActionListener(this);
        btnPanel.add(btnRight);

        btnUp = new JButton("Move Up");
        btnUp.addActionListener(this);
        btnPanel.add(btnUp);

        btnDown = new JButton("Move Down");
        btnDown.addActionListener(this);
        btnPanel.add(btnDown);

        // Add both panels to JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(p, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);

        // Set up JFrame
        addKeyListener(this);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLeft) {
            p.xLock -= 10;
        } else if (e.getSource() == btnRight) {
            p.xLock += 10;
        } else if (e.getSource() == btnUp) {
            p.yLock -= 10;
        } else if (e.getSource() == btnDown) {
            p.yLock += 10;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                p.xLock -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                p.xLock += 10;
                break;
            case KeyEvent.VK_UP:
                p.yLock -= 10;
                break;
            case KeyEvent.VK_DOWN:
                p.yLock += 10;
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}