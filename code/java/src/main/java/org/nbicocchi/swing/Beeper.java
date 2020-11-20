package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;

public class Beeper extends JFrame {
    private static final long serialVersionUID = 5775123950929476076L;
    JButton btnBeep;

    public Beeper() {
        super("Beeper");
        btnBeep = new JButton("Click Me!");
        btnBeep.addActionListener((evt) -> Toolkit.getDefaultToolkit().beep());

        JPanel p = new JPanel();
        p.add(btnBeep);

        setContentPane(p);
        setSize(200, 60);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Beeper::new);
    }
}