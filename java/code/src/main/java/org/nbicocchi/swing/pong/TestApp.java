package org.nbicocchi.swing.pong;

import javax.swing.*;
import java.awt.*;

public class TestApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame f = new JFrame("Pong");

            PongPanel pong = new PongPanel();

            f.setContentPane(pong);
            f.setSize(600, 400);
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.setVisible(true);

            pong.init();
        });
    }
}
