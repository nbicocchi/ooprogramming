package org.nbicocchi.swing.imagecomparator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

interface ProgressListener {
    void progressPerformed(int percent);
}

public abstract class AbstractComparator implements Runnable {
    protected BufferedImage img_a;
    protected BufferedImage img_b;
    protected float similarity;
    List<ProgressListener> listeners = new ArrayList<>();

    public AbstractComparator(BufferedImage img_a, BufferedImage img_b) {
        this.img_a = img_a;
        this.img_b = img_b;
    }

    public void addListener(ProgressListener toAdd) {
        listeners.add(toAdd);
    }

    public void notifyListeners(int percent) {
        for (ProgressListener hl : listeners)
            hl.progressPerformed(percent);
    }

    public float getCoverage() {
        float coverage = (img_a.getWidth() * img_a.getHeight()) / (float) (img_b.getWidth() * img_b.getHeight());
        if (coverage < 1) {
            return coverage;
        }
        return 1 / coverage;
    }

    public float getSimilarity() {
        return similarity;
    }

}