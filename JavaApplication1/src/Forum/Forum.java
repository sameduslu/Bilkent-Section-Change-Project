/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forum;

import ResultMessage.Accepted;
import ResultMessage.Denied;
import SchedulePage.SchedulePage;
import SectionChange.SectionChangePage;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import main.Courses;
import main.Student;

/**
 * @author cagri
 */
public class Forum extends javax.swing.JFrame {
    private Student student;
    private Courses courses;
    /**
     * Creates new form Forum
     */
    public Forum(Student student, Courses courses) {
        this.setSize(1280,720);
        this.setLocationRelativeTo(null);
        this.student = student;
        this.courses = courses;
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMinimize = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jForumAcceptButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jForumAcceptButton3 = new javax.swing.JButton();
        jForumAcceptButton2 = new javax.swing.JButton();
        forum2 = new javax.swing.JTextField();
        forum3 = new javax.swing.JTextField();
        forum1 = new javax.swing.JTextField();
        jForumAcceptButton4 = new javax.swing.JButton();
        forum4 = new javax.swing.JTextField();
        forum5 = new javax.swing.JTextField();
        jForumAcceptButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonSectionChange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1268, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1268, 720));

        jPanel1.setBackground(new java.awt.Color(220, 172, 146));

        jLabelMinimize.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
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

        jButton1.setBackground(new java.awt.Color(220, 172, 146));
        jButton1.setForeground(new java.awt.Color(220, 172, 146));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SectionChange/home.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jForumAcceptButton5.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/A.png"))); // NOI18N
        jForumAcceptButton5.setBorder(null);
        jForumAcceptButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForumAcceptButton5ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(173, 112, 96));
        jLabel1.setFont(new java.awt.Font("PT Sans Caption", 1, 90)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(173, 112, 96));
        jLabel1.setText("FORUM");

        jForumAcceptButton3.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/A.png"))); // NOI18N
        jForumAcceptButton3.setBorder(null);
        jForumAcceptButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForumAcceptButton3ActionPerformed(evt);
            }
        });

        jForumAcceptButton2.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/A.png"))); // NOI18N
        jForumAcceptButton2.setBorder(null);
        jForumAcceptButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForumAcceptButton2ActionPerformed(evt);
            }
        });

        forum2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forum2ActionPerformed(evt);
            }
        });

        forum3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        forum1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forum1ActionPerformed(evt);
            }
        });

        jForumAcceptButton4.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/A.png"))); // NOI18N
        jForumAcceptButton4.setBorder(null);
        jForumAcceptButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForumAcceptButton4MouseClicked(evt);
            }
        });
        jForumAcceptButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForumAcceptButton4ActionPerformed(evt);
            }
        });

        forum4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forum4ActionPerformed(evt);
            }
        });

        forum5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forum5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forum5ActionPerformed(evt);
            }
        });

        jForumAcceptButton1.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/A.png"))); // NOI18N
        jForumAcceptButton1.setBorder(null);
        jForumAcceptButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jForumAcceptButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(220, 172, 146));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/arrow_reverse.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(220, 172, 146));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forum/arrow.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonSectionChange.setBackground(new java.awt.Color(220, 172, 146));
        jButtonSectionChange.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jButtonSectionChange.setForeground(new java.awt.Color(172, 112, 96));
        jButtonSectionChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LoginPage/a.png"))); // NOI18N
        jButtonSectionChange.setText("FORUM REQUEST");
        jButtonSectionChange.setToolTipText("");
        jButtonSectionChange.setBorder(null);
        jButtonSectionChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSectionChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSectionChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSectionChangeMouseClicked(evt);
            }
        });
        jButtonSectionChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSectionChangeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonSectionChange, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelMinimize)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabelClose))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forum2, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forum4, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forum3, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forum5, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forum1, javax.swing.GroupLayout.PREFERRED_SIZE, 931, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jForumAcceptButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jForumAcceptButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jForumAcceptButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jForumAcceptButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jForumAcceptButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelClose)
                        .addComponent(jLabelMinimize))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jForumAcceptButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jForumAcceptButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jForumAcceptButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jForumAcceptButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jForumAcceptButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(forum5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(forum1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(forum2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(forum4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(forum3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSectionChange, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizeMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizeMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SchedulePage sPage = new SchedulePage(this.student, courses);
        sPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jForumAcceptButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForumAcceptButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForumAcceptButton5ActionPerformed

    private void jForumAcceptButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForumAcceptButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForumAcceptButton3ActionPerformed

    private void jForumAcceptButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForumAcceptButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForumAcceptButton2ActionPerformed

    private void forum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forum2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forum2ActionPerformed

    private void jForumAcceptButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForumAcceptButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jForumAcceptButton4ActionPerformed

    private void forum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forum1ActionPerformed

    private void forum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forum4ActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_forum4ActionPerformed

    private void forum5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forum5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forum5ActionPerformed

    private void jForumAcceptButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jForumAcceptButton1ActionPerformed
        // TODO add your handling code here:
        boolean passed = true;
        if(passed){
            Accepted accept = new Accepted("abc");
            accept.setLocationRelativeTo(null);
            accept.setVisible(true);
        }
        else{
            Denied denied = new Denied("bcd");
            denied.setLocationRelativeTo(null);
            denied.setVisible(true);
            
        }
    }//GEN-LAST:event_jForumAcceptButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jForumAcceptButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jForumAcceptButton4MouseClicked
        // TODO add your handling code here::
        Forum forum = new Forum(student, courses);
        forum.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jForumAcceptButton4MouseClicked

    private void jButtonSectionChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSectionChangeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSectionChangeMouseClicked

    private void jButtonSectionChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSectionChangeActionPerformed
        
    }//GEN-LAST:event_jButtonSectionChangeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField forum1;
    private javax.swing.JTextField forum2;
    private javax.swing.JTextField forum3;
    private javax.swing.JTextField forum4;
    private javax.swing.JTextField forum5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonSectionChange;
    private javax.swing.JButton jForumAcceptButton1;
    private javax.swing.JButton jForumAcceptButton2;
    private javax.swing.JButton jForumAcceptButton3;
    private javax.swing.JButton jForumAcceptButton4;
    private javax.swing.JButton jForumAcceptButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMinimize;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
