package org.nbicocchi.swing.fractalviewer;

import javax.swing.*;

/**
 * Simple Java program to display the Mandelbrot set (using a special {@link
 * MandelbrotPanel} object. The depth limit for the iteration can be set via a
 * command line argument. This version adds support for multiple windows and
 * includes menus and dialog panels.
 */
public class TestApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MandelbrotFrame(MandelbrotFrame.DEFAULT_LIMIT));
    }
}
