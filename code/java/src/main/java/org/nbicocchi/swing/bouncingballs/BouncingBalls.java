package org.nbicocchi.swing.bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BouncingBalls extends JFrame {
    private static final long serialVersionUID = 1L;

    public BouncingBalls() {
        super();

        // loads configuration
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("balls.cfg"));
        } catch (IOException e) {
            System.out.println("Error while reading defaults...");
        }

        // check for default values
        if (p.getProperty("sounds") == null) {
            p.setProperty("sounds", "on");
        }

        if (p.getProperty("pause") == null) {
            p.setProperty("pause", "off");
        }

        if (p.getProperty("fps") == null) {
            p.setProperty("fps", "60");
        }

        GamePanel gp = new GamePanel(p);
        ControlPanel cp = new ControlPanel(p);
        gp.setControlPanel(cp);
        cp.setGamePanel(gp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(gp, BorderLayout.CENTER);
        c.add(cp, BorderLayout.SOUTH);
        setSize(600, 400);
        setVisible(true);

        gp.init();
    }

}

