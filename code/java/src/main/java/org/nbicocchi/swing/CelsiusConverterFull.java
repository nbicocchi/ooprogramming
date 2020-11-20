package org.nbicocchi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CelsiusConverterFull extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JButton CFButton;
    private final JButton FCButton;
    private final JTextField fahrenheitTF;
    private final JTextField celsiusTF;

    public CelsiusConverterFull() {
        super("Celsius Converter");
        celsiusTF = new JTextField("0");
        fahrenheitTF = new JTextField("32");
        CFButton = new JButton("°C->°F");
        CFButton.addActionListener(this);
        FCButton = new JButton("°F->°C");
        FCButton.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(2, 2));
        p1.add(celsiusTF);
        p1.add(new JLabel("°C"));
        p1.add(fahrenheitTF);
        p1.add(new JLabel("°F"));

        JPanel p2 = new JPanel(new GridLayout(1, 2));
        p2.add(CFButton);
        p2.add(FCButton);

        JPanel p3 = new JPanel(new BorderLayout());
        p3.add(p1, BorderLayout.NORTH);
        p3.add(p2, BorderLayout.SOUTH);

        /* JFrame methods called */
        setContentPane(p3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == CFButton) {
            double tempFahrenheit = Double.parseDouble(celsiusTF.getText()) * 1.8 + 32;
            fahrenheitTF.setText(Double.toString(tempFahrenheit));

            if (tempFahrenheit < 32) {
                JOptionPane.showMessageDialog(this, "Water freezes here!", "Temperature Warning",
                        JOptionPane.WARNING_MESSAGE);
            }

        }
        if (e.getSource() == FCButton) {
            double tempCelsius = (Double.parseDouble(fahrenheitTF.getText()) - 32) * 0.555;
            celsiusTF.setText(Double.toString(tempCelsius));

            if (tempCelsius < 0) {
                JOptionPane.showMessageDialog(this, "Water freezes here!", "Temperature Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CelsiusConverterFull::new);
    }
}
