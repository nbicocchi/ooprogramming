package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;

public class LayoutManager extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LayoutManager::new);
    }

    public LayoutManager() {
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(new JButton("A"), BorderLayout.NORTH);
        p1.add(new JButton("B"), BorderLayout.WEST);
        p1.add(new JButton("C"), BorderLayout.CENTER);
        p1.add(new JButton("D"), BorderLayout.EAST);
        p1.add(new JButton("E"), BorderLayout.SOUTH);

        JPanel p2 = new JPanel(new GridLayout(3, 2));
        p2.add(new JButton("F"));
        p2.add(new JButton("G"));
        p2.add(new JButton("H"));
        p2.add(new JButton("I"));
        p2.add(new JButton("J"));
        p2.add(new JButton("K"));

        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(new JButton("L"));
        p3.add(new JButton("M"));
        p3.add(new JButton("N"));
        p3.add(new JButton("O"));
        p3.add(new JButton("P"));

        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p1, BorderLayout.CENTER);
        p4.add(p2, BorderLayout.PAGE_END);
        p4.add(p3, BorderLayout.LINE_END);

        setContentPane(p4);
        pack();
        setVisible(true);
    }

}