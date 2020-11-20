package org.nbicocchi.jdbc.coursemanager;

import org.nbicocchi.jdbc.DBManager;
import org.nbicocchi.utils.Utils;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseManager extends JFrame implements ChangeListener {
    PanelStudent pnStudents;
    PanelCourse pnCourses;
    JTabbedPane tabbedPane;

    public CourseManager() {
        super("Student Manager");

        try {
            testConnection();
            pnStudents = new PanelStudent();
            pnCourses = new PanelCourse();
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Database Error!" + e.getMessage());
        }

        tabbedPane = new JTabbedPane();
        tabbedPane.setTabPlacement(JTabbedPane.TOP);
        tabbedPane.setPreferredSize(new Dimension(700, 400));
        tabbedPane.addChangeListener(this);

        tabbedPane.addTab("Students", pnStudents);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Courses", pnCourses);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        setContentPane(tabbedPane);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*
     * useful during development, not for deployment!
     */
    public void testConnection() throws SQLException {
        DBManager.setConnection(
                Utils.JDBC_Driver_MySQL,
                Utils.JDBC_URL_MySQL);
        Statement statement = DBManager.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        try {
            statement.executeQuery("SELECT * FROM courses LIMIT 1");
            statement.executeQuery("SELECT * FROM students LIMIT 1");
        } catch (SQLException e) {
            statement.executeUpdate("DROP TABLE IF EXISTS students");
            statement.executeUpdate("DROP TABLE IF EXISTS courses");
            statement.executeUpdate("DROP TABLE IF EXISTS students_courses");
            statement.executeUpdate("CREATE TABLE students (id BINARY(16) PRIMARY KEY, name VARCHAR(50), surname VARCHAR(50), birthdate DATE)");
            statement.executeUpdate("CREATE TABLE courses (id BINARY(16) PRIMARY KEY, name VARCHAR(50), teachers INTEGER, cfu INTEGER)");
            statement.executeUpdate("CREATE TABLE students_courses (student_id BINARY(16) NOT NULL, course_id BINARY(16) NOT NULL, FOREIGN KEY (student_id) REFERENCES students (id), FOREIGN KEY (course_id) REFERENCES courses (id), PRIMARY KEY (student_id, course_id))");
            statement.executeUpdate("INSERT INTO students (id, name, surname, birthdate) VALUES (UUID_TO_BIN('2b38ee22-1efd-11eb-9a33-cdb1134a383e'), 'Mario', 'Rossi', '2000-10-21')");
            statement.executeUpdate("INSERT INTO students (id, name, surname, birthdate) VALUES (UUID_TO_BIN('2b391474-1efd-11eb-9a33-cdb1134a383e'), 'Maria', 'Verdi', '2001-06-11')");
            statement.executeUpdate("INSERT INTO students (id, name, surname, birthdate) VALUES (UUID_TO_BIN('2b393be8-1efd-11eb-9a33-cdb1134a383e'), 'Lucia', 'Neri', '2000-03-16')");
            statement.executeUpdate("INSERT INTO courses (id, name, teachers, cfu) VALUES (UUID_TO_BIN('2b39731a-1efd-11eb-9a33-cdb1134a383e'), 'Math I', 2, 9)");
            statement.executeUpdate("INSERT INTO courses (id, name, teachers, cfu) VALUES (UUID_TO_BIN('2b3995a2-1efd-11eb-9a33-cdb1134a383e'), 'Physics I', 2, 9)");
            statement.executeUpdate("INSERT INTO courses (id, name, teachers, cfu) VALUES (UUID_TO_BIN('2b39ba1e-1efd-11eb-9a33-cdb1134a383e'), 'OOP', 1, 9)");
            statement.executeUpdate("INSERT INTO students_courses (student_id, course_id) VALUES (UUID_TO_BIN('2b38ee22-1efd-11eb-9a33-cdb1134a383e'), UUID_TO_BIN('2b39731a-1efd-11eb-9a33-cdb1134a383e'))");
            statement.executeUpdate("INSERT INTO students_courses (student_id, course_id) VALUES (UUID_TO_BIN('2b38ee22-1efd-11eb-9a33-cdb1134a383e'), UUID_TO_BIN('2b3995a2-1efd-11eb-9a33-cdb1134a383e'))");
            statement.executeUpdate("INSERT INTO students_courses (student_id, course_id) VALUES (UUID_TO_BIN('2b391474-1efd-11eb-9a33-cdb1134a383e'), UUID_TO_BIN('2b39ba1e-1efd-11eb-9a33-cdb1134a383e'))");
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        pnCourses.update();
        pnStudents.update();
    }
}
