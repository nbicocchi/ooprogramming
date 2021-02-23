package org.nbicocchi.jdbc.sausagemanager;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SM_JTable extends JFrame implements ActionListener, TableModelListener {
    private static final long serialVersionUID = 1L;

    JTable tResults;
    JButton btInsert;
    JButton btDelete;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btInsert) {
            String[] v = JOptionPane.showInputDialog(this, "Insert sausage (length;diameter;weight;quality)")
                    .split(";");
            ((SM_JTable_Model) tResults.getModel()).insertRow(v);
        }

        if (e.getSource() == btDelete) {
            ((SM_JTable_Model) tResults.getModel()).removeRow(tResults.getSelectedRow(),
                    tResults.getSelectedRow());
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println("The table has been modified!");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(SM_JTable::new);
    }

    public SM_JTable() {
        super("Sausage Manager");

        try {
            tResults = new JTable();
            tResults.setModel(new SM_JTable_Model());
            tResults.getModel().addTableModelListener(this);
            tResults.setGridColor(Color.BLACK);
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Database Error!");
        }

        btInsert = new JButton("Insert...");
        btInsert.addActionListener(this);
        btDelete = new JButton("Remove");
        btDelete.addActionListener(this);

        JPanel p01 = new JPanel(new GridLayout(1, 2));
        p01.add(btInsert);
        p01.add(btDelete);

        setLayout(new BorderLayout());
        add(p01, BorderLayout.SOUTH);
        add(new JScrollPane(tResults), BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
