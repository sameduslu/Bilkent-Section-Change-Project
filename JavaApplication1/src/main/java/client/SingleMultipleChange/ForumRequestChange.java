/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package client.SingleMultipleChange;

import client.main.Connection;
import client.main.Course;
import client.main.ForumRequest;
import client.main.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * @author Pc
 */
public class ForumRequestChange extends JFrame {

    /**
     * Creates new form Forum Request
     */
    private Student student;
    private List<Course> courses;

    public ForumRequestChange(Student student) {
        this.student = Connection.getUpdatedStudent(student.getId());
        courses = Connection.getAllCoursesFromServer();
        this.setLocationRelativeTo(null);
        initComponents2(this);
    }

    public void close() {
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void initComponents2(ForumRequestChange forumRequestChange) {
        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(220, 172, 146));
        jPanel1.setPreferredSize(new Dimension(350, 350));
        jPanel1.setLayout(new GridLayout(5, 5, 20, 20));
        jPanel2 = new JPanel();
        jPanel2.setBackground(new Color(220, 172, 146));
        jLabelClose = new JLabel();
        jLabelClose.setFont(new Font("Lucida Handwriting", 1, 48)); // NOI18N
        jLabelClose.setForeground(new Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelClose.setHorizontalTextPosition(SwingConstants.CENTER);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i).getId());
            JButton button = new JButton(courses.get(i).getId());
            button.setBackground(new Color(220, 172, 146));
            button.setFont(new Font("Bahnschrift", 1, 24)); // NOI18N
            button.setForeground(new Color(172, 112, 96));
            button.setIcon(new ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button2.png")); // NOI18N
            button.setText(courses.get(i).getId());
            button.setToolTipText("");
            button.setBorder(null);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setMaximumSize(new Dimension(340, 117));
            button.setMinimumSize(new Dimension(340, 117));
            button.setPreferredSize(new Dimension(340, 117));
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //Connection.sendSingleRequest(student.getId(), button.getText());
                    Course cc = new Course(null,null,null,null);
                    cc.setId(button.getText());
                    ForumRequest fReq = new ForumRequest(student,cc,null);
                    Connection.sendForumRequest(fReq);
                    //singlechange.close();

                    forumRequestChange.dispose();
                }
            });
            jPanel1.add(button);
        }
        jPanel2.setBackground(new Color(220, 172, 146));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 990, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabelClose)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelClose)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 756, Short.MAX_VALUE)
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        button = new JToggleButton();
        jToggleButton2 = new JToggleButton();
        jToggleButton4 = new JToggleButton();
        jToggleButton3 = new JToggleButton();
        jToggleButton6 = new JToggleButton();
        jToggleButton5 = new JToggleButton();
        jButton1 = new JButton();
        jPanel2 = new JPanel();
        jLabelClose = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(220, 172, 146));
        jPanel1.setPreferredSize(new Dimension(350, 350));
        jPanel1.setLayout(new GridLayout(5, 5, 20, 20));

        button.setBackground(new Color(220, 172, 146));
        button.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        button.setBorder(null);
        button.setMaximumSize(new Dimension(533, 303));
        button.setMinimumSize(new Dimension(533, 303));
        button.setPreferredSize(new Dimension(533, 303));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        jPanel1.add(button);

        jToggleButton2.setBackground(new Color(220, 172, 146));
        jToggleButton2.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        jToggleButton2.setBorder(null);
        jToggleButton2.setHorizontalTextPosition(SwingConstants.CENTER);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton2);

        jToggleButton4.setBackground(new Color(220, 172, 146));
        jToggleButton4.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        jToggleButton4.setBorder(null);
        jToggleButton4.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel1.add(jToggleButton4);

        jToggleButton3.setBackground(new Color(220, 172, 146));
        jToggleButton3.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        jToggleButton3.setBorder(null);
        jToggleButton3.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel1.add(jToggleButton3);

        jToggleButton6.setBackground(new Color(220, 172, 146));
        jToggleButton6.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        jToggleButton6.setBorder(null);
        jToggleButton6.setHorizontalTextPosition(SwingConstants.CENTER);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton6);

        jToggleButton5.setBackground(new Color(220, 172, 146));
        jToggleButton5.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        jToggleButton5.setBorder(null);
        jToggleButton5.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel1.add(jToggleButton5);

        jButton1.setBackground(new Color(220, 172, 146));
        jButton1.setFont(new Font("Baskerville", 1, 24)); // NOI18N
        jButton1.setForeground(new Color(172, 112, 96));
        jButton1.setIcon(new ImageIcon(getClass().getResource("/SingleMultipleChange/button2.png"))); // NOI18N
        jButton1.setText("SEND");
        jButton1.setBorder(null);
        jButton1.setHorizontalTextPosition(SwingConstants.CENTER);
        jPanel1.add(jButton1);

        jPanel2.setBackground(new Color(220, 172, 146));

        jLabelClose.setFont(new Font("Lucida Handwriting", 1, 48)); // NOI18N
        jLabelClose.setForeground(new Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelClose.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelClose))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelClose)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 976, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 887, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabelCloseMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JToggleButton button;
    private JButton jButton1;
    private JLabel jLabelClose;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JToggleButton jToggleButton2;
    private JToggleButton jToggleButton3;
    private JToggleButton jToggleButton4;
    private JToggleButton jToggleButton5;
    private JToggleButton jToggleButton6;
    // End of variables declaration//GEN-END:variables
}
