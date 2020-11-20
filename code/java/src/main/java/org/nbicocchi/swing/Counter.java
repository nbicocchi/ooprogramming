package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Counter extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JButton btnInc;
    private final JButton btnDec;
    private final JLabel label;

    public Counter() {
        super("Counter");
        btnInc = new JButton("+");
        btnInc.addActionListener(this);
        btnDec = new JButton("-");
        btnDec.addActionListener(this);
        label = new JLabel("0");

        JPanel p = new JPanel();
        p.add(btnInc);
        p.add(btnDec);
        p.add(label);

        add(p);
        setSize(250, 70);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInc) {
            int n = Integer.parseInt(label.getText()) + 1;
            label.setText(Integer.toString(n));
        } else if (e.getSource() == btnDec) {
            int n = Integer.parseInt(label.getText()) - 1;
            label.setText(Integer.toString(n));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Counter::new);
    }

}
