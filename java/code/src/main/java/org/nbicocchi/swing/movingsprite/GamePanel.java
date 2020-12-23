package org.nbicocchi.swing.movingsprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    BufferedImage image;
    int xLock, yLock, rLock;

    public GamePanel(Dimension d, String path) {
        super();
        setPreferredSize(d);
        setBackground(Color.black);

        this.xLock = 0;
        this.yLock = 0;
        try {
            this.image = ImageIO.read(new File(path));
            this.rLock = image.getWidth();
            if (image.getWidth() != image.getHeight()) {
                throw new IllegalArgumentException();
            }
        } catch (IOException | IllegalArgumentException e) {
            this.image = null;
            this.rLock = 50;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            g.drawImage(image, xLock, yLock, null);
        } else {
            g.setColor(Color.red);
            g.fillOval(xLock, yLock, rLock, rLock);
        }
    }
}