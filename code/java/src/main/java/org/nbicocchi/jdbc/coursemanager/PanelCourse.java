package org.nbicocchi.jdbc.coursemanager;

import org.nbicocchi.jdbc.DBManager;
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
import java.util.UUID;

public class PanelCourse extends JPanel implements ActionListener {
    private final JButton btnNext;
    private final JButton btnPrev;
    private final JButton btnRemove;
    private final JButton btnInsert;
    private final JTextField tfID;
    private final JTextField tfName;
    private final JTextField tfTeachers;
    private final JTextField tfCfu;

    private final List<Course> listCourses;
    private int selectedCourseIndex = 0;

    public PanelCourse() throws SQLException {
        super();
        listCourses = getAllCourses();

        btnNext = new JButton("Next");
        btnNext.addActionListener(this);
        btnPrev = new JButton("Previous");
        btnPrev.addActionListener(this);
        btnRemove = new JButton("Delete");
        btnRemove.addActionListener(this);
        btnInsert = new JButton("Insert");
        btnInsert.addActionListener(this);

        tfID = new JTextField();
        tfName = new JTextField();
        tfName.addActionListener(this);
        tfTeachers = new JTextField();
        tfTeachers.addActionListener(this);
        tfCfu = new JTextField();
        tfCfu.addActionListener(this);

        /* text fields panel */
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 4));
        p1.add(new JLabel("ID"));
        p1.add(tfID);
        p1.add(new JLabel("Course name"));
        p1.add(tfName);
        p1.add(new JLabel("Teachers"));
        p1.add(tfTeachers);
        p1.add(new JLabel("Cfu"));
        p1.add(tfCfu);

        /* buttons panel */
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 4));
        p2.add(btnPrev);
        p2.add(btnNext);
        p2.add(btnRemove);
        p2.add(btnInsert);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.PAGE_START);
        add(p2, BorderLayout.PAGE_END);

        update();
    }

    public void update() {
        try {
            listCourses.clear();
            listCourses.addAll(getAllCourses());
            Course course = listCourses.get(selectedCourseIndex);

            tfID.setText(course.getID().toString());
            tfName.setText(course.getName());
            tfTeachers.setText(Integer.valueOf(course.getTeachers()).toString());
            tfCfu.setText(Integer.valueOf(course.getCfu()).toString());
        } catch (IndexOutOfBoundsException | SQLException e) {
            tfID.setText("n/a");
            tfName.setText("n/a");
            tfTeachers.setText("n/a");
            tfCfu.setText("n/a");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnNext) {
                selectedCourseIndex = Math.min(selectedCourseIndex + 1, listCourses.size() - 1);
            }

            if (e.getSource() == btnPrev) {
                selectedCourseIndex = Math.max(selectedCourseIndex - 1, 0);
            }

            if (e.getSource() == btnInsert) {
                String[] v = JOptionPane.showInputDialog(this, "Insert course (name;teachers;cfu)")
                        .split(";");
                insertCourse(new Course(UUID.randomUUID(), v[0], Integer.parseInt(v[1]), Integer.parseInt(v[2])));
            }

            Course course = listCourses.get(selectedCourseIndex);
            if (e.getSource() == btnRemove) {
                removeCourse(course);
                selectedCourseIndex = Math.max(selectedCourseIndex - 1, 0);
            }

            if (e.getSource() == tfName) {
                updateCourse(course, "name", tfName.getText());
            }

            if (e.getSource() == tfTeachers) {
                updateCourse(course, "teachers", tfTeachers.getText());
            }

            if (e.getSource() == tfCfu) {
                updateCourse(course, "cfu", tfCfu.getText());
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            update();
        }
    }

    public List<Course> getAllCourses() throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        Statement statement = DBManager.getConnection().createStatement();
        String query = "SELECT * FROM courses";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            courses.add(
                    new Course(Utils.asUUID(rs.getBytes("id")),
                            rs.getString("name"),
                            rs.getInt("teachers"),
                            rs.getInt("cfu"))
            );
        }
        statement.close();
        return courses;
    }

    public void insertCourse(Course course) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("INSERT INTO courses (id, name, teachers, cfu) VALUES (UUID_TO_BIN('%s'), '%s', '%d', '%d')",
                course.getID().toString(),
                course.getName(),
                course.getTeachers(),
                course.getCfu());
        statement.executeUpdate(query);
        statement.close();
    }

    public void removeCourse(Course course) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("DELETE FROM courses WHERE id = UUID_TO_BIN('%s')",
                course.getID());
        statement.executeUpdate(query);
        statement.close();
    }

    public void updateCourse(Course course, String field, String value) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("UPDATE courses SET %s = '%s' WHERE id = UUID_TO_BIN('%s')",
                field,
                value,
                course.getID());
        statement.executeUpdate(query);
        statement.close();
    }
}
