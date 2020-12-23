package org.nbicocchi.swing.imagecomparator;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FastComparator extends AbstractComparator {
    public FastComparator(BufferedImage img_a, BufferedImage img_b) {
        super(img_a, img_b);
    }

    @Override
    public void run() {
        int w = Math.min(img_a.getWidth(), img_b.getWidth());
        int h = Math.min(img_a.getHeight(), img_b.getHeight());

        int d = 0;
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                Color c1 = new Color(img_a.getRGB(x, y));
                Color c2 = new Color(img_b.getRGB(x, y));
                d += Math.abs(c1.getGreen() - c2.getGreen()) +
                        Math.abs(c1.getRed() - c2.getRed()) +
                        Math.abs(c1.getBlue() - c2.getBlue());
            }
            notifyListeners(100 * x / w);
        }
        similarity = 1 - (d / (float) (w * h * 255 * 3));
        notifyListeners(100);
    }
}
