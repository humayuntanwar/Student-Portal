package portal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class main  {

    JFrame f1 = new JFrame("Main Menu");
    JButton b1 = new JButton("Student"), b2 = new JButton("Faculty"), b3 = new JButton("Admin");
                    JTextField tid = new JTextField(13);


    main() {
        f1.setVisible(true);
        f1.setSize(300, 350);

        f1.setLayout(null);
        // f1.pack();
        f1.setLocationRelativeTo(null);

        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        b2.setBounds(100, 50, 80, 20);
        b1.setBounds(100, 100, 80, 20);
        b3.setBounds(100, 150, 80, 20);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.dispose();
                JFrame st = new JFrame("Student Login");
                 JButton back=new JButton("Back");
                st.pack();
                st.setLocationRelativeTo(null);
                st.setVisible(true);
                st.setSize(300, 300);
                st.setLayout(null);
                
                JButton b = new JButton("Enter");
                JLabel id = new JLabel("Registration#");
                JLabel pas = new JLabel("Pasword");
                JPasswordField tp = new JPasswordField(10);
                
                id.setBounds(20, 30, 100, 20);
                pas.setBounds(20, 70, 100, 20);
                tid.setBounds(150, 30, 100, 20);
                tp.setBounds(150, 70, 100, 20);
                b.setBounds(150, 120, 80, 20);
                back.setBounds(80,120,80,20);

                st.add(b);
                st.add(id);
                st.add(tid);
                st.add(pas);
                st.add(tp);
                st.add(back);
                
                st.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        st.dispose();
                        new Student();

                    }
                });
                 back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        st.dispose();
                        new main();

                    }
                });
                

            }
        });
    }

   
}
