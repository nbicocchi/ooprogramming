package org.nbicocchi.jdbc.sausagemanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;

public class SM_Updatable extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static String[] qualities = {"High", "Average", "Low", "Shitty"};

    SM_Updatable_Model model;

    JTextField tfLength;
    JTextField tfDiameter;
    JTextField tfWeight;
    JComboBox<String> cbQuality;

    JButton btnPrev;
    JButton btnNext;
    JButton btnInsert;
    JButton btnRemove;

    public SM_Updatable() {
        super("Sausage Manager");

        tfLength = new JTextField();
        tfDiameter = new JTextField();
        tfWeight = new JTextField();
        cbQuality = new JComboBox<>(qualities);

        btnPrev = new JButton("Prev");
        btnNext = new JButton("Next");
        btnInsert = new JButton("Insert");
        btnRemove = new JButton("Remove");

        tfLength.addActionListener(this);
        tfDiameter.addActionListener(this);
        tfWeight.addActionListener(this);
        cbQuality.addActionListener(this);

        btnPrev.addActionListener(this);
        btnNext.addActionListener(this);
        btnInsert.addActionListener(this);
        btnRemove.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(4, 2));
        p1.add(new JLabel("Length"));
        p1.add(tfLength);

        p1.add(new JLabel("Diameter"));
        p1.add(tfDiameter);

        p1.add(new JLabel("Weight"));
        p1.add(tfWeight);

        p1.add(new JLabel("Quality"));
        p1.add(cbQuality);

        JPanel p2 = new JPanel(new GridLayout(2, 2));
        p2.add(btnPrev);
        p2.add(btnNext);
        p2.add(btnInsert);
        p2.add(btnRemove);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        try {
            model = new SM_Updatable_Model();
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Database Error!");
        }
        showItem();
    }

    public void showItem() {
        try {
            tfLength.setText(Double.toString(model.getSelectedItem().getLength()));
            tfDiameter.setText(Double.toString(model.getSelectedItem().getDiameter()));
            tfWeight.setText(Double.toString(model.getSelectedItem().getWeight()));
            cbQuality.setSelectedItem(model.getSelectedItem().getQuality());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            tfLength.setText("");
            tfDiameter.setText("");
            tfWeight.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            model.next();
            showItem();
        } else if (e.getSource() == btnPrev) {
            model.previous();
            showItem();
        } else if (e.getSource() == btnInsert) {
            String[] v = JOptionPane.showInputDialog(this, "Insert sausage (length;diameter;weight;quality)")
                    .split(";");
            model.insert(Double.parseDouble(v[0]), Double.parseDouble(v[1]), Double.parseDouble(v[2]), v[3]);
            showItem();
        } else if (e.getSource() == btnRemove) {
            model.remove();
            showItem();
        } else if (e.getSource() == tfLength) {
            model.setLength(Double.parseDouble(tfLength.getText()));
        } else if (e.getSource() == tfDiameter) {
            model.setDiameter(Double.parseDouble(tfDiameter.getText()));
        } else if (e.getSource() == tfWeight) {
            model.setWeight(Double.parseDouble(tfWeight.getText()));
        } else if (e.getSource() == cbQuality) {
            model.setQuality(Objects.requireNonNull(cbQuality.getSelectedItem()).toString());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(SM_Updatable::new);
    }
}
