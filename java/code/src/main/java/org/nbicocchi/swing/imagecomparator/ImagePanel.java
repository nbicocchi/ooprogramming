package org.nbicocchi.swing.imagecomparator;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private BufferedImage image = null;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        this.repaint();
        this.revalidate();
    }

    @Override
    public Dimension getPreferredSize() {
        if (image == null) {
            return new Dimension();
        }
        return new Dimension(image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }

    }

}