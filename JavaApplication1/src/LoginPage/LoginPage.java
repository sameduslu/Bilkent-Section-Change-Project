/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LoginPage;

import SchedulePage.SchedulePage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import main.Student;

/**
 *
 * @author Pc
 */
public class LoginPage extends javax.swing.JFrame {

    private ArrayList<Student> students;
    public LoginPage(ArrayList<Student> students) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.students = students;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonLogin = new javax.swing.JButton();
        jLabelClose = new javax.swing.JLabel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelRegister = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jTextFieldID = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(220, 172, 146));

        jButtonLogin.setBackground(new java.awt.Color(220, 172, 146));
        jButtonLogin.setFont(new java.awt.Font("Bahnschrift", 1, 32)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(220, 172, 146));
        jButtonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage/a.png"))); // NOI18N
        jButtonLogin.setText("Login");
        jButtonLogin.setToolTipText("");
        jButtonLogin.setBorder(null);
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Lucida Handwriting", 1, 48)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabelMinimize.setFont(new java.awt.Font("Lucida Handwriting", 1, 48)); // NOI18N
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked(evt);
            }
        });

        jLabelRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage/My_project_8.png"))); // NOI18N

        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage/b.png"))); // NOI18N
        jLabelID.setLabelFor(jTextFieldID);
        jLabelID.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabelID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jLabelIDInputMethodTextChanged(evt);
            }
        });

        jPasswordFieldPassword.setBackground(new java.awt.Color(220, 172, 146));
        jPasswordFieldPassword.setText("jPasswordField1");
        jPasswordFieldPassword.setBorder(null);
        jPasswordFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldPasswordActionPerformed(evt);
            }
        });

        jTextFieldID.setBackground(new java.awt.Color(220, 172, 146));
        jTextFieldID.setText("jTextFieldID");
        jTextFieldID.setBorder(null);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage/b.png"))); // NOI18N
        jLabelPassword.setLabelFor(jTextFieldID);
        jLabelPassword.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelPassword.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jLabelPasswordInputMethodTextChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 401, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
        // TODO add your handling code here:
        String studentID = jTextFieldID.getText();
        int count = 0;
        String studentPassword = jPasswordFieldPassword.getText();
        try{
            File database = new File("/Users/cagri/Desktop/School/Spring_Semester/CS-102/CS102-Project/Bilkent-Section-Change-Project/Names_and_IDs.txt");
            Scanner sc = new Scanner(database);
            while(sc.hasNextLine()) {
                String name = sc.next();
                String surname = sc.next();
                name += (" " + surname); 
                String id = sc.next();
                String password = sc.next();
                if (/*studentID.equals(id) && studentPassword.equals(password)*/true) {
                    SchedulePage sPage = new SchedulePage(students.get(count));
                    sPage.setVisible(true);
                    this.dispose();
                    break;
                }
                count++;
            }
            System.out.println("not registered!!");
            sc.close();
        }
        catch (FileNotFoundException err)  {
            System.out.println("Error occured!");
        }
    }//GEN-LAST:event_jButtonLoginMouseClicked

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jLabelIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabelIDInputMethodTextChanged

    }//GEN-LAST:event_jLabelIDInputMethodTextChanged

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jPasswordFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldPasswordActionPerformed

    private void jLabelPasswordInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabelPasswordInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelPasswordInputMethodTextChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}
