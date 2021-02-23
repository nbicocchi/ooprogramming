package org.nbicocchi.jdbc.sausagemanager;

import org.nbicocchi.jdbc.DBManager;
import org.nbicocchi.utils.Sausage;
import org.nbicocchi.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SM_Forward extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    public static String[] qualities = {"High", "Average", "Low", "Shitty"};

    List<Sausage> lm;
    int selectedItem;

    JTextField tfLength;
    JTextField tfDiameter;
    JTextField tfWeight;
    JComboBox<String> cbQuality;

    JButton btnPrev;
    JButton btnNext;
    JButton btnInsert;
    JButton btnRemove;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            selectedItem = Math.min(selectedItem + 1, lm.size() - 1);
            showItem();
        }

        if (e.getSource() == btnPrev) {
            selectedItem = Math.max(selectedItem - 1, 0);
            showItem();
        }

        if (e.getSource() == btnInsert) {
            String[] v = JOptionPane.showInputDialog(this, "Insert sausage (length;diameter;weight;quality)")
                    .split(";");
            Sausage m = new Sausage(java.util.UUID.randomUUID(), Double.parseDouble(v[0]), Double.parseDouble(v[1]),
                    Double.parseDouble(v[2]), v[3]);

            try {
                String query = String.format(
                        "INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('%s', %f, %f, %f, '%s')",
                        m.getId().toString(), m.getLength(), m.getDiameter(), m.getWeight(), m.getQuality());
                Statement statement = DBManager.getConnection().createStatement();
                statement.executeUpdate(query);
                statement.close();
                lm.add(m);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            selectedItem = lm.size() - 1;
            showItem();
        }

        if (e.getSource() == btnRemove) {
            try {
                String query = String.format("DELETE FROM sausage WHERE id='%s'", lm.get(selectedItem).getId());
                Statement statement = DBManager.getConnection().createStatement();
                statement.executeUpdate(query);
                statement.close();
                lm.remove(selectedItem);
                selectedItem = Math.max(selectedItem - 1, 0);
            } catch (IndexOutOfBoundsException | SQLException e1) {
                e1.printStackTrace();
            }
            showItem();
        }

        if (e.getSource() == tfLength) {
            String query = String.format("UPDATE sausage SET length=%f WHERE id='%s'",
                    Double.parseDouble(tfLength.getText()), lm.get(selectedItem).getId());
            try {
                Statement statement = DBManager.getConnection().createStatement();
                statement.executeUpdate(query);
                statement.close();
                lm.get(selectedItem).setLength(Double.parseDouble(tfLength.getText()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == tfDiameter) {
            String query = String.format("UPDATE sausage SET diameter=%f WHERE id='%s'",
                    Double.parseDouble(tfDiameter.getText()), lm.get(selectedItem).getId());
            try {
                Statement statement = DBManager.getConnection().createStatement();
                statement.executeUpdate(query);
                statement.close();
                lm.get(selectedItem).setDiameter(Double.parseDouble(tfDiameter.getText()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == tfWeight) {
            String query = String.format("UPDATE sausage SET weight=%f WHERE id='%s'",
                    Double.parseDouble(tfWeight.getText()), lm.get(selectedItem).getId());
            try {
                Statement statement = DBManager.getConnection().createStatement();
                statement.executeUpdate(query);
                statement.close();
                lm.get(selectedItem).setWeight(Double.parseDouble(tfWeight.getText()));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == cbQuality) {
            String query = String.format("UPDATE sausage SET quality='%s' WHERE id='%s'", cbQuality.getSelectedItem(),
                    lm.get(selectedItem).getId());
            try {
                Statement statement = DBManager.getConnection().createStatement();
                statement.executeUpdate(query);
                statement.close();
                lm.get(selectedItem).setQuality(Objects.requireNonNull(cbQuality.getSelectedItem()).toString());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(SM_Forward::new);
    }

    public SM_Forward() {
        super("Sausage Manager");

        lm = new ArrayList<>();

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
        p1.add(new JLabel("length"));
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
            testConnection();
            load();
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Database Error!");
        }
    }

    public void testConnection() throws SQLException {
        DBManager.setConnection(
                Utils.JDBC_Driver_SQLite,
                Utils.JDBC_URL_SQLite);
        Statement statement = DBManager.getConnection().createStatement();

        try {
            statement.executeQuery("SELECT * FROM sausage LIMIT 1");
        } catch (SQLException e) {
            statement.executeUpdate("DROP TABLE IF EXISTS sausage");
            statement.executeUpdate("CREATE TABLE sausage (" + "id VARCHAR(50) PRIMARY KEY, " + "length REAL, diameter REAL, " + "weight REAL, " + "quality VARCHAR(50))");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('214bb0db-aa52-48be-b052-cd30f730ae79', 30.2, 30.0, 2.6, 'High')");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('03e9e721-f241-4539-9cc7-baecd8b3a931', 40.3, 35.5, 2.2, 'Low')");
            statement.executeUpdate("INSERT INTO sausage (id, length, diameter, weight, quality) VALUES ('e1f0dcb0-181b-4463-97d7-edcfed736ae1', 35.1, 28.2, 4.3, 'High')");
        }
    }

    public void load() throws SQLException {
        selectedItem = 0;

        Statement statement = DBManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM sausage");
        while (rs.next()) {
            lm.add(new Sausage(java.util.UUID.fromString(rs.getString("id")), rs.getDouble("length"),
                    rs.getDouble("diameter"), rs.getDouble("weight"), rs.getString("quality")));
        }
        statement.close();
        showItem();
    }

    public void showItem() {
        try {
            tfLength.setText(Double.toString(lm.get(selectedItem).getLength()));
            tfDiameter.setText(Double.toString(lm.get(selectedItem).getDiameter()));
            tfWeight.setText(Double.toString(lm.get(selectedItem).getWeight()));
            cbQuality.setSelectedItem(lm.get(selectedItem).getQuality());
        } catch (IndexOutOfBoundsException e) {
            tfLength.setText("");
            tfDiameter.setText("");
            tfWeight.setText("");
        }
    }
}
