package org.nbicocchi.swing.fractalviewer;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

/**
 * Simple Java program to display the Mandelbrot set (using a special {@link
 * MandelbrotPanel} object. The depth limit for the iteration can be set via a
 * command line argument. This version adds support for multiple windows and
 * includes menus and dialog panels.
 */
public class TestApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame("Fractal viewer");
            JPanel p = new MandelbrotPanel(255);
            f.getContentPane().add(p);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(800, 800);
            f.setVisible(true);
        });
    }
}
