package client.SingleMultipleChange;

import client.main.Connection;
import client.main.Course;
import client.main.Student;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SingleChange extends javax.swing.JFrame {

    private final Student student;
    private final List<Course> courses;

    public SingleChange(Student student) {
        this.student = Connection.getUpdatedStudent(student.getId());
        courses = Connection.getAllCoursesFromServer();
        this.setLocationRelativeTo(null);
        initComponents2(this);
    }

    private void initComponents2(SingleChange singlechange) {
        JPanel jPanel1 = new JPanel();
        jPanel1.setBackground(new java.awt.Color(220, 172, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 350));
        jPanel1.setLayout(new java.awt.GridLayout(5, 5, 20, 20));
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(new java.awt.Color(220, 172, 146));
        JLabel jLabelClose = new JLabel();
        jLabelClose.setFont(new java.awt.Font("Lucida Handwriting", 1, 48));
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked();
            }
        });
        for (Course c : courses) {
            JButton button = new JButton(c.getId());
            button.setBackground(new Color(220, 172, 146));
            button.setFont(new Font("Bahnschrift", 1, 24));
            button.setForeground(new Color(172, 112, 96));
            button.setIcon(new ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button2.png"));
            button.setText(c.getId());
            button.setToolTipText("");
            button.setBorder(null);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setMaximumSize(new Dimension(340, 117));
            button.setMinimumSize(new Dimension(340, 117));
            button.setPreferredSize(new Dimension(340, 117));
            button.addActionListener(evt -> {
                Connection.sendSingleRequest(student.getId(), button.getText());
                singlechange.dispose();
            });
            jPanel1.add(button);
        }
        jPanel2.setBackground(new java.awt.Color(220, 172, 146));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabelClose)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelClose)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();

    }

    private void jLabelCloseMouseClicked() {
        this.dispose();
    }
}
