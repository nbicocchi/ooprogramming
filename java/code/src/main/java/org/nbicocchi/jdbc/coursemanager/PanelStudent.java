package org.nbicocchi.jdbc.coursemanager;

import org.nbicocchi.jdbc.DBManager;
import org.nbicocchi.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PanelStudent extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;
    private final JButton btnNext;
    private final JButton btnPrev;
    private final JButton btnRemove;
    private final JButton btnInsert;
    private final JTextField tfName;
    private final JTextField tfSurname;
    private final JTextField tfID;
    private final JTextField tfBirthDate;

    private final List<Student> listStudents;
    private final DefaultComboBoxModel<Course> cbCoursesModel;
    private final JComboBox<Course> cbCourses;
    private final DefaultListModel<Course> listCoursesModel;
    private final JList<Course> listCourses;
    private final JButton btnCourseAdd;
    private final JButton btnCourseDel;

    private int selectedStudentIndex = 0;

    public PanelStudent() throws SQLException {
        super();

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
        tfSurname = new JTextField();
        tfSurname.addActionListener(this);
        tfBirthDate = new JTextField();
        tfBirthDate.addActionListener(this);

        listStudents = getAllStudents();
        cbCoursesModel = new DefaultComboBoxModel<>();
        cbCourses = new JComboBox<>(cbCoursesModel);
        listCoursesModel = new DefaultListModel<>();
        listCourses = new JList<>(listCoursesModel);

        btnCourseAdd = new JButton("+");
        btnCourseAdd.addActionListener(this);
        btnCourseDel = new JButton("-");
        btnCourseDel.addActionListener(this);

        /* text fields panel */
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 4));
        p1.add(new JLabel("ID"));
        p1.add(tfID);
        p1.add(new JLabel("Birth Date"));
        p1.add(tfBirthDate);
        p1.add(new JLabel("First Name"));
        p1.add(tfName);
        p1.add(new JLabel("Last Name"));
        p1.add(tfSurname);

        /* moving buttons panel */
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 4));
        p2.add(btnPrev);
        p2.add(btnNext);
        p2.add(btnRemove);
        p2.add(btnInsert);

        /* courses panel */
        JPanel p3 = new JPanel();
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        p3.add(btnCourseAdd);
        p3.add(btnCourseDel);

        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(cbCourses, BorderLayout.PAGE_START);
        p4.add(listCourses, BorderLayout.CENTER);
        p4.add(p3, BorderLayout.LINE_END);

        JPanel p5 = new JPanel(new BorderLayout());
        p5.add(new JSeparator(), BorderLayout.PAGE_START);
        p5.add(new JSeparator(), BorderLayout.PAGE_END);
        p5.add(p4, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(p1, BorderLayout.PAGE_START);
        add(p2, BorderLayout.PAGE_END);
        add(p5, BorderLayout.CENTER);

        update();
    }

    public List<Student> getAllStudents() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        Statement statement = DBManager.getConnection().createStatement();
        String query = "SELECT * FROM students";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            students.add(
                    new Student(Utils.asUUID(rs.getBytes("id")),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getDate("birthdate"))
            );
        }
        statement.close();
        return students;
    }

    public void update() {
        try {
            listStudents.clear();
            listStudents.addAll(getAllStudents());
            Student student = listStudents.get(selectedStudentIndex);

            cbCoursesModel.removeAllElements();
            cbCoursesModel.addAll(getAllCourses());
            cbCourses.setSelectedIndex(0);
            listCoursesModel.clear();
            listCoursesModel.addAll(getStudentCourses(student));

            tfID.setText(student.getID().toString());
            tfName.setText(student.getName());
            tfSurname.setText(student.getSurname());
            tfBirthDate.setText(student.getBirthDate().toString());
        } catch (IndexOutOfBoundsException | SQLException e) {
            tfID.setText("n/a");
            tfName.setText("n/a");
            tfSurname.setText("n/a");
            tfBirthDate.setText("n/a");
            JOptionPane.showMessageDialog(this, e.getMessage());
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

    public List<Course> getStudentCourses(Student student) throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("SELECT\n" +
                "courses.id,\n" +
                "courses.name,\n" +
                "courses.teachers,\n" +
                "courses.cfu\n" +
                "FROM students\n" +
                "JOIN students_courses ON students.id = students_courses.student_id\n" +
                "JOIN courses ON courses.id = students_courses.course_id\n" +
                "WHERE students.id = UUID_TO_BIN('%s')", student.getID());
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

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnNext) {
                selectedStudentIndex = Math.min(selectedStudentIndex + 1, listStudents.size() - 1);
            }

            if (e.getSource() == btnPrev) {
                selectedStudentIndex = Math.max(selectedStudentIndex - 1, 0);
            }

            if (e.getSource() == btnInsert) {
                String[] v = JOptionPane.showInputDialog(this, "Insert student (name;surname;birthday[YYYY-MM-DD])")
                        .split(";");
                insertStudent(new Student(UUID.randomUUID(), v[0], v[1], Date.valueOf(v[2])));
            }

            Student student = listStudents.get(selectedStudentIndex);
            if (e.getSource() == btnRemove) {
                removeStudent(student);
                selectedStudentIndex = Math.max(selectedStudentIndex - 1, 0);
            }

            if (e.getSource() == tfName) {
                updateStudent(student, "name", tfName.getText());
            }

            if (e.getSource() == tfSurname) {
                updateStudent(student, "surname", tfSurname.getText());
            }

            if (e.getSource() == tfBirthDate) {
                updateStudent(student, "birthdate", tfBirthDate.getText());
            }

            if (e.getSource() == btnCourseAdd) {
                Course course = cbCourses.getModel().getElementAt(cbCourses.getSelectedIndex());
                addStudentCourse(student, course);
            }
            if (e.getSource() == btnCourseDel) {
                Course course = listCourses.getModel().getElementAt(listCourses.getSelectedIndex());
                delStudentCourse(student, course);
            }
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            update();
        }
    }

    public void insertStudent(Student student) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("INSERT INTO students (id, name, surname, birthdate) VALUES (UUID_TO_BIN('%s'), '%s', '%s', '%s')",
                student.getID().toString(),
                student.getName(),
                student.getSurname(),
                student.getBirthDate().toString());
        statement.executeUpdate(query);
        statement.close();
    }

    public void removeStudent(Student student) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("DELETE FROM students WHERE id = UUID_TO_BIN('%s')",
                student.getID());
        statement.executeUpdate(query);
        statement.close();
    }

    public void updateStudent(Student student, String field, String value) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("UPDATE students SET %s = '%s' WHERE id = UUID_TO_BIN('%s')",
                field,
                value,
                student.getID());
        statement.executeUpdate(query);
        statement.close();
    }

    public void addStudentCourse(Student student, Course course) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("INSERT INTO students_courses (student_id, course_id) VALUES (UUID_TO_BIN('%s'), UUID_TO_BIN('%s'))",
                student.getID(),
                course.getID());
        statement.executeUpdate(query);
        statement.close();
    }

    public void delStudentCourse(Student student, Course course) throws SQLException {
        Statement statement = DBManager.getConnection().createStatement();
        String query = String.format("DELETE FROM students_courses WHERE (student_id = UUID_TO_BIN('%s') AND course_id = UUID_TO_BIN('%s'))",
                student.getID(),
                course.getID());
        statement.executeUpdate(query);
        statement.close();
    }
}
