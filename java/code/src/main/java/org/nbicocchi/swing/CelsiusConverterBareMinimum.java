package org.nbicocchi.swing;

import javax.swing.*;

public class CelsiusConverterBareMinimum extends JFrame {
    private static final long serialVersionUID = 1L;
    private final JButton FCButton;
    private final JTextField fahrenheitTF;
    private final JTextField celsiusTF;

    public CelsiusConverterBareMinimum() {
        super("Celsius Converter");
        celsiusTF = new JTextField("000");
        fahrenheitTF = new JTextField("032");
        JButton CFButton = new JButton("°C->°F");
        FCButton = new JButton("°F->°C");

        JPanel p1 = new JPanel();
        p1.add(celsiusTF);
        p1.add(new JLabel("°C"));
        p1.add(fahrenheitTF);
        p1.add(new JLabel("°F"));
        p1.add(CFButton);
        p1.add(FCButton);

        /* JFrame methods called */
        setContentPane(p1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(350, 75);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CelsiusConverterBareMinimum::new);
    }
}
