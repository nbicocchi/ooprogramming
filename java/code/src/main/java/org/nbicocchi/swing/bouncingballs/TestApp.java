package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;

public class TestApp {
    public static void main(String[] args) {
        // Run GUI construction on the Event-Dispatching Thread for thread safety
        SwingUtilities.invokeLater(BouncingBalls::new);
    }
}
