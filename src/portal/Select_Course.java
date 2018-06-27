/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package portal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Kashif
 */
public class Select_Course {

    Select_Course() {
        JFrame marks = new JFrame("Marks");
        JFrame select_course = new JFrame("Select Course");
        JButton back_b = new JButton("Back");
        select_course.setVisible(true);
        select_course.setSize(600, 600);
        select_course.setLocationRelativeTo(null);
        select_course.setLayout(null);
        select_course.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        select_course.add(back_b);
        back_b.setBounds(10, 500, 80, 20);
        JTable mt;

        Vector m1 = new Vector();
        Vector m3 = new Vector();
        m1.addElement("S#");
        m1.addElement("Employee Id");
        m1.addElement("Courses");

        try {
            Con_db a = new Con_db();
            Statement st = a.c.createStatement();
            ResultSet rs = st.executeQuery("Select * from employees ");
            int i = 1;
            while (rs.next()) {
                Vector m2 = new Vector();
                m2.addElement(i);
                i = i + 1;
                m2.addElement(rs.getString("employee_id"));
                m2.addElement(rs.getString("first_name"));
                m3.add(m2);
            }
        } catch (SQLException o) {
            System.out.println(" not connected");
        }
        mt = new JTable(m3, m1);
        JScrollPane js = new JScrollPane(mt);
        select_course.add(js);
        js.setBounds(10, 10, 400, 400);
        //Back Button Action
        back_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                select_course.dispose();
                new Student().student_console.setVisible(true);
            }
        });
        mt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {

                System.out.println(mt.getValueAt(mt.getSelectedRow(), 1).toString());
                select_course.dispose();

                marks.setVisible(true);
                marks.setSize(600, 600);
                marks.setLocationRelativeTo(null);
                marks.setLayout(null);
                marks.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                Vector m1 = new Vector();
                Vector m3 = new Vector();
                m1.addElement("S#");
                m1.addElement("Employee_Id");
                m1.addElement("Name");
                m1.addElement("Department Id");
                try {
                    Con_db a = new Con_db();
                    Statement st = a.c.createStatement();
                    // int s=102;
                    ResultSet rs = st.executeQuery("Select * from employees where employee_id= " + mt.getValueAt(mt.getSelectedRow(), 1).toString());
                    int i = 1;
                    while (rs.next()) {
                        Vector m2 = new Vector();
                        m2.addElement(i);
                        i = i + 1;
                        m2.addElement(rs.getString("employee_id"));
                        m2.addElement(rs.getString("first_name"));

                        m2.addElement(rs.getString("department_id"));

                        m3.add(m2);
                    }
                } catch (SQLException o) {
                    System.out.println(" not connected");
                }
                JTable mt;

                mt = new JTable(m3, m1);
                //  mt.setEnabled(false);
                JScrollPane js = new JScrollPane(mt);
                marks.add(js);
                mt.setEnabled(false);
                js.setBounds(10, 10, 400, 400);
                marks.add(back_b);
                back_b.setBounds(10, 450, 80, 20);
                  JButton back_b1=new JButton("Back");
                back_b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent c) {
                        marks.dispose();

                        
                        new main();
                    }

                });
            }
        });

    }
}
