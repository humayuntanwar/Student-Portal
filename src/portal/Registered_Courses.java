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

/**
 *
 * @author Kashif
 */
public class Registered_Courses {
   Registered_Courses(){
       JFrame r=new JFrame("Registered Courses");
       JButton back_b=new JButton("Back");
           
                

                r.setVisible(true);
                r.setSize(600, 600);
                r.setLocationRelativeTo(null);
                r.setLayout(null);
                r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                r.add(back_b);
                back_b.setBounds(10, 500, 80, 20);
                //JTable mt;
               

                Vector m1 = new Vector();
                Vector m3 = new Vector();
                m1.addElement("S#");
                m1.addElement("Course ID");
                m1.addElement("Courses Name ");
                m1.addElement("Teacher");

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
                        m2.addElement(rs.getString("department_id"));
                        m3.add(m2);
                    }
                } catch (SQLException o) {
                    System.out.println(" not connected");
                }
                JTable re;
                re = new JTable(m3, m1);
                 re.setEnabled(false);
                JScrollPane js = new JScrollPane(re);
                r.add(js);
                js.setBounds(10, 10, 400, 400);
            
                //Back Button Action
                back_b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        r.dispose();
                        new Student();

                    }

                });
   }
    
}
