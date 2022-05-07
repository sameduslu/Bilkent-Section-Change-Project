/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SingleMultipleChange;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import main.Courses;
import main.Student;

/**
 *
 * @author Pc
 */
public class MultipleChange extends javax.swing.JFrame {

    /**
     * Creates new form SingleChange
     */
    private Student student;
    private Courses courses;
    public MultipleChange(Student student, Courses courses) {
        this.student = student;
        this.courses = courses;
        this.setLocationRelativeTo(null);
        initComponents2(this);
    }

    private void initComponents2(MultipleChange singlechange) {
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new java.awt.Color(220, 172, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 350));
        jPanel1.setLayout(new java.awt.GridLayout(5, 5, 20, 20));
        Send = new javax.swing.JButton();
        for (int i = 0; i < courses.getSize(); i++) {
            JToggleButton button = new javax.swing.JToggleButton(courses.getCourse(i).getName());
            button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
            jPanel1.add(button);
        }
        
        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });
        jPanel1.add(Send);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
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

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        Send = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(220, 172, 146));
        jPanel1.setPreferredSize(new java.awt.Dimension(350, 350));
        jPanel1.setLayout(new java.awt.GridLayout(5, 5, 20, 20));

        jToggleButton1.setText("jToggleButton1");
        jPanel1.add(jToggleButton1);

        jToggleButton2.setText("jToggleButton2");
        jPanel1.add(jToggleButton2);

        jToggleButton3.setText("jToggleButton3");
        jPanel1.add(jToggleButton3);

        jToggleButton4.setText("jToggleButton4");
        jPanel1.add(jToggleButton4);

        jToggleButton6.setText("jToggleButton6");
        jPanel1.add(jToggleButton6);

        jToggleButton5.setText("jToggleButton5");
        jPanel1.add(jToggleButton5);

        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });
        jPanel1.add(Send);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_SendActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Send;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    // End of variables declaration//GEN-END:variables
}