package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JLabel label;

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("+")) {
            int n = Integer.parseInt(label.getText()) + 1;
            label.setText(Integer.toString(n));
        } else if (e.getActionCommand().equals("-")) {
            int n = Integer.parseInt(label.getText()) - 1;
            label.setText(Integer.toString(n));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Counter::new);
    }

    public Counter() {
        super("Counter");
        JButton btnInc = new JButton("+");
        btnInc.addActionListener(this);
        JButton btnDec = new JButton("-");
        btnDec.addActionListener(this);
        label = new JLabel("0");

        JPanel p = new JPanel(new GridLayout(1, 3));
        p.add(btnInc);
        p.add(btnDec);
        p.add(label);

        setContentPane(p);
        setSize(250, 70);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
