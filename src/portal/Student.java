/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Student {

    main getID = new main();
    JFrame r = new JFrame("Registered Courses");
    JFrame select_course = new JFrame("Select Course");
    JFrame student_console = new JFrame("Student Console");
    JFrame marks = new JFrame("Marks");
    JButton register_course_b = new JButton("Registered Course"), marks_b = new JButton("Marks"), signout_b = new JButton("Sign out");
    JButton back_b = new JButton("Back");
    JTable t;
    JTextArea h = new JTextArea(40, 20);
    Vector v1 = new Vector();
    Vector v3 = new Vector();

    Student() {

        v1.addElement("Id");
        v1.addElement("Name");
        v1.addElement("Salary");
        v1.addElement("Department");

        student_console.setVisible(true);
        student_console.setSize(600, 600);
        student_console.setLocationRelativeTo(null);
        student_console.setLayout(null);
        student_console.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        student_console.add(register_course_b);
        student_console.add(marks_b);
        student_console.add(signout_b);

        register_course_b.setBounds(10, 40, 140, 20);
        marks_b.setBounds(10, 80, 100, 20);
        signout_b.setBounds(10, 120, 100, 20);
        try {
            Con_db a = new Con_db();
            Statement st = a.c.createStatement();
            //Statement st1 = c.createStatement();

            ResultSet rs = st.executeQuery("Select * from student where student_id = " + getID.tid.getText().toString() );

            while (rs.next()) {
                Vector v2 = new Vector();
                v2.addElement(rs.getString("Student_id"));
                v2.addElement(rs.getString(2));
                v2.addElement(rs.getString(3));
                v2.addElement(rs.getString(4));

                v3.add(v2);
            }

            rs.close();

        } catch (SQLException e) {
            System.out.println(" not connected");
        }
        t = new JTable(v3, v1);
        t.setEnabled(false);
        JScrollPane sp = new JScrollPane(t);
        sp.setBounds(160, 40, 600, 600);
        student_console.add(sp);

        register_course_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                student_console.dispose();
                new Registered_Courses();
            }
        });

        marks_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                student_console.dispose();
                new Select_Course();
            }
        });
        signout_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                student_console.dispose();
                new main();
            }
        });

    }

}
