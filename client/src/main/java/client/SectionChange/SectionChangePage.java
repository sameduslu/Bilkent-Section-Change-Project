package client.SectionChange;

import client.Forum.Forum;
import client.SchedulePage.SchedulePage;
import client.SingleMultipleChange.MultipleChange;
import client.SingleMultipleChange.SingleChange;
import client.main.Connection;
import client.main.Student;

import javax.swing.*;

public class SectionChangePage extends javax.swing.JFrame {

    private final Student student;

    public SectionChangePage(Student student) {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.student = Connection.getUpdatedStudent(student.getId());
        initComponents();

    }
    private void initComponents() {
        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JPanel jPanel2 = new JPanel();
        JTextField jTextField20 = new JTextField();
        JTextField jTextField18 = new JTextField();
        JTextField jTextField30 = new JTextField();
        JTextField jTextField32 = new JTextField();
        JTextField jTextField33 = new JTextField();
        JTextField jTextField34 = new JTextField();
        JTextField jTextField21 = new JTextField();
        JTextField jTextField35 = new JTextField();
        JTextField jTextField36 = new JTextField();
        JTextField jTextField56 = new JTextField();
        JTextField jTextField37 = new JTextField();
        JTextField jTextField42 = new JTextField();
        JTextField jTextField22 = new JTextField();
        JTextField jTextField43 = new JTextField();
        JTextField jTextField45 = new JTextField();
        JTextField jTextField46 = new JTextField();
        JTextField jTextField47 = new JTextField();
        JTextField jTextField48 = new JTextField();
        JTextField jTextField38 = new JTextField();
        JTextField jTextField49 = new JTextField();
        JTextField jTextField51 = new JTextField();
        JTextField jTextField52 = new JTextField();
        JTextField jTextField53 = new JTextField();
        JTextField jTextField54 = new JTextField();
        JTextField jTextField39 = new JTextField();
        JTextField jTextField55 = new JTextField();
        JTextField jTextField57 = new JTextField();
        JTextField jTextField58 = new JTextField();
        JTextField jTextField59 = new JTextField();
        JTextField jTextField60 = new JTextField();
        JTextField jTextField40 = new JTextField();
        JTextField jTextField61 = new JTextField();
        JTextField jTextField62 = new JTextField();
        JTextField jTextField63 = new JTextField();
        JTextField jTextField64 = new JTextField();
        JTextField jTextField65 = new JTextField();
        JTextField jTextField41 = new JTextField();
        JTextField jTextField66 = new JTextField();
        JTextField jTextField67 = new JTextField();
        JTextField jTextField68 = new JTextField();
        JTextField jTextField69 = new JTextField();
        JTextField jTextField70 = new JTextField();
        JTextField jTextField44 = new JTextField();
        JTextField jTextField71 = new JTextField();
        JTextField jTextField72 = new JTextField();
        JTextField jTextField73 = new JTextField();
        JTextField jTextField74 = new JTextField();
        JTextField jTextField75 = new JTextField();
        JTextField jTextField50 = new JTextField();
        JTextField jTextField76 = new JTextField();
        JTextField jTextField77 = new JTextField();
        JTextField jTextField78 = new JTextField();
        JTextField jTextField79 = new JTextField();
        JTextField jTextField80 = new JTextField();
        JTextField jTextField81 = new JTextField();
        JTextField jTextField82 = new JTextField();
        JTextField jTextField83 = new JTextField();
        JTextField jTextField84 = new JTextField();
        JTextField jTextField85 = new JTextField();
        JTextField jTextField86 = new JTextField();
        JButton jButtonSectionChange = new JButton();
        JButton jButtonForum = new JButton();
        JLabel jLabelClose = new JLabel();
        JButton jButtonMultiChange = new JButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton homeButton = new JButton();
        JLabel jLabelMinimize = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 172, 146));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(220, 172, 146));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(173, 112, 96));
        jLabel1.setFont(new java.awt.Font("PT Sans Caption", 1, 36));
        jLabel1.setForeground(new java.awt.Color(173, 112, 96));
        jLabel1.setText("Current Schedule");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, -20, 440, 100);

        jPanel2.setBackground(new java.awt.Color(220, 172, 146));
        jPanel2.setLayout(new java.awt.GridLayout(10, 6, 20, 20));

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(173, 112, 96));
        jTextField20.setFont(new java.awt.Font("PT Sans Caption", 1, 14));
        jTextField20.setForeground(new java.awt.Color(220, 172, 146));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("Hours");
        jPanel2.add(jTextField20);

        jTextField18.setEditable(false);
        jTextField18.setBackground(new java.awt.Color(173, 112, 96));
        jTextField18.setFont(new java.awt.Font("PT Sans Caption", 1, 14));
        jTextField18.setForeground(new java.awt.Color(220, 172, 146));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("Mon");
        jPanel2.add(jTextField18);

        jTextField30.setEditable(false);
        jTextField30.setBackground(new java.awt.Color(173, 112, 96));
        jTextField30.setFont(new java.awt.Font("PT Sans Caption", 1, 14));
        jTextField30.setForeground(new java.awt.Color(220, 172, 146));
        jTextField30.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField30.setText("Tue");
        jPanel2.add(jTextField30);

        jTextField32.setEditable(false);
        jTextField32.setBackground(new java.awt.Color(173, 112, 96));
        jTextField32.setFont(new java.awt.Font("PT Sans Caption", 1, 14));
        jTextField32.setForeground(new java.awt.Color(220, 172, 146));
        jTextField32.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField32.setText("Wed");
        jPanel2.add(jTextField32);

        jTextField33.setEditable(false);
        jTextField33.setBackground(new java.awt.Color(173, 112, 96));
        jTextField33.setFont(new java.awt.Font("PT Sans Caption", 1, 14));
        jTextField33.setForeground(new java.awt.Color(220, 172, 146));
        jTextField33.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField33.setText("Thurs");
        jPanel2.add(jTextField33);

        jTextField34.setEditable(false);
        jTextField34.setBackground(new java.awt.Color(173, 112, 96));
        jTextField34.setFont(new java.awt.Font("PT Sans Caption", 1, 14));
        jTextField34.setForeground(new java.awt.Color(220, 172, 146));
        jTextField34.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField34.setText("Fri");
        jPanel2.add(jTextField34);

        jTextField21.setEditable(false);
        jTextField21.setBackground(new java.awt.Color(173, 112, 96));
        jTextField21.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField21.setForeground(new java.awt.Color(220, 172, 146));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setText("8.30-9.20");
        jPanel2.add(jTextField21);

        jTextField35.setEditable(false);
        jTextField35.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField35.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField35.setText(student.getCourseAt(1, 1));
        jPanel2.add(jTextField35);

        jTextField36.setEditable(false);
        jTextField36.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField36.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField36.setText(student.getCourseAt(1, 2));
        jPanel2.add(jTextField36);

        jTextField56.setEditable(false);
        jTextField56.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField56.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField56.setText(student.getCourseAt(1, 3));
        jPanel2.add(jTextField56);

        jTextField37.setEditable(false);
        jTextField37.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField37.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField37.setText(student.getCourseAt(1, 4));
        jPanel2.add(jTextField37);

        jTextField42.setEditable(false);
        jTextField42.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField42.setText(student.getCourseAt(1, 5));
        jTextField42.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField42);

        jTextField22.setEditable(false);
        jTextField22.setBackground(new java.awt.Color(173, 112, 96));
        jTextField22.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField22.setForeground(new java.awt.Color(220, 172, 146));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setText("9.30-10.20");
        jPanel2.add(jTextField22);

        jTextField43.setEditable(false);
        jTextField43.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField43.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField43.setText(student.getCourseAt(2, 1));
        jPanel2.add(jTextField43);

        jTextField45.setEditable(false);
        jTextField45.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField45.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField45.setText(student.getCourseAt(2, 2));
        jPanel2.add(jTextField45);

        jTextField46.setEditable(false);
        jTextField46.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField46.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField46.setText(student.getCourseAt(2, 3));
        jPanel2.add(jTextField46);

        jTextField47.setEditable(false);
        jTextField47.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField47.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField47.setText(student.getCourseAt(2, 4));
        jPanel2.add(jTextField47);

        jTextField48.setEditable(false);
        jTextField48.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField48.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField48.setText(student.getCourseAt(2, 5));
        jPanel2.add(jTextField48);

        jTextField38.setEditable(false);
        jTextField38.setBackground(new java.awt.Color(173, 112, 96));
        jTextField38.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField38.setForeground(new java.awt.Color(220, 172, 146));
        jTextField38.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField38.setText("10.30-11.20");
        jTextField38.setToolTipText("");
        jPanel2.add(jTextField38);

        jTextField49.setEditable(false);
        jTextField49.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField49.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField49.setText(student.getCourseAt(3, 1));
        jPanel2.add(jTextField49);

        jTextField51.setEditable(false);
        jTextField51.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField51.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField51.setText(student.getCourseAt(3, 2));
        jPanel2.add(jTextField51);

        jTextField52.setEditable(false);
        jTextField52.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField52.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField52.setText(student.getCourseAt(3, 3));
        jPanel2.add(jTextField52);

        jTextField53.setEditable(false);
        jTextField53.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField53.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField53.setText(student.getCourseAt(3, 4));
        jPanel2.add(jTextField53);

        jTextField54.setEditable(false);
        jTextField54.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField54.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField54.setText(student.getCourseAt(3, 5));
        jPanel2.add(jTextField54);

        jTextField39.setEditable(false);
        jTextField39.setBackground(new java.awt.Color(173, 112, 96));
        jTextField39.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField39.setForeground(new java.awt.Color(220, 172, 146));
        jTextField39.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField39.setText("11.30-12.20");
        jPanel2.add(jTextField39);

        jTextField55.setEditable(false);
        jTextField55.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField55.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField55.setText(student.getCourseAt(4, 1));
        jPanel2.add(jTextField55);

        jTextField57.setEditable(false);
        jTextField57.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField57.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField57.setText(student.getCourseAt(4, 2));
        jPanel2.add(jTextField57);

        jTextField58.setEditable(false);
        jTextField58.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField58.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField58.setText(student.getCourseAt(4, 3));
        jPanel2.add(jTextField58);

        jTextField59.setEditable(false);
        jTextField59.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField59.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField59.setText(student.getCourseAt(4, 4));
        jPanel2.add(jTextField59);

        jTextField60.setEditable(false);
        jTextField60.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField60.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField60.setText(student.getCourseAt(4, 5));
        jPanel2.add(jTextField60);

        jTextField40.setEditable(false);
        jTextField40.setBackground(new java.awt.Color(173, 112, 96));
        jTextField40.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField40.setForeground(new java.awt.Color(220, 172, 146));
        jTextField40.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField40.setText("12.30-13.20");
        jTextField40.setToolTipText("");
        jPanel2.add(jTextField40);

        jTextField61.setEditable(false);
        jTextField61.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField61.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField61);

        jTextField62.setEditable(false);
        jTextField62.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField62.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField62);

        jTextField63.setEditable(false);
        jTextField63.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField63.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField63);

        jTextField64.setEditable(false);
        jTextField64.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField64.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField64);

        jTextField65.setEditable(false);
        jTextField65.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField65.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(jTextField65);

        jTextField41.setEditable(false);
        jTextField41.setBackground(new java.awt.Color(173, 112, 96));
        jTextField41.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField41.setForeground(new java.awt.Color(220, 172, 146));
        jTextField41.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField41.setText("13.30-14.20");
        jTextField41.setToolTipText("");
        jPanel2.add(jTextField41);

        jTextField66.setEditable(false);
        jTextField66.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField66.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField66.setText(student.getCourseAt(5, 1));
        jPanel2.add(jTextField66);

        jTextField67.setEditable(false);
        jTextField67.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField67.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField67.setText(student.getCourseAt(5, 2));
        jPanel2.add(jTextField67);

        jTextField68.setEditable(false);
        jTextField68.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField68.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField68.setText(student.getCourseAt(5, 3));
        jPanel2.add(jTextField68);

        jTextField69.setEditable(false);
        jTextField69.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField69.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField69.setText(student.getCourseAt(5, 4));
        jPanel2.add(jTextField69);

        jTextField70.setEditable(false);
        jTextField70.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField70.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField70.setText(student.getCourseAt(5, 5));
        jPanel2.add(jTextField70);

        jTextField44.setEditable(false);
        jTextField44.setBackground(new java.awt.Color(173, 112, 96));
        jTextField44.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField44.setForeground(new java.awt.Color(220, 172, 146));
        jTextField44.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField44.setText("14.30.15.20");
        jTextField44.setToolTipText("");
        jPanel2.add(jTextField44);

        jTextField71.setEditable(false);
        jTextField71.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField71.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField71.setText(student.getCourseAt(6, 1));
        jPanel2.add(jTextField71);

        jTextField72.setEditable(false);
        jTextField72.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField72.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField72.setText(student.getCourseAt(6, 2));
        jPanel2.add(jTextField72);

        jTextField73.setEditable(false);
        jTextField73.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField73.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField73.setText(student.getCourseAt(6, 3));
        jPanel2.add(jTextField73);

        jTextField74.setEditable(false);
        jTextField74.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField74.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField74.setText(student.getCourseAt(6, 4));
        jPanel2.add(jTextField74);

        jTextField75.setEditable(false);
        jTextField75.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField75.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField75.setText(student.getCourseAt(6, 5));
        jPanel2.add(jTextField75);

        jTextField50.setEditable(false);
        jTextField50.setBackground(new java.awt.Color(173, 112, 96));
        jTextField50.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField50.setForeground(new java.awt.Color(220, 172, 146));
        jTextField50.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField50.setText("15.30-16.20");
        jPanel2.add(jTextField50);

        jTextField76.setEditable(false);
        jTextField76.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField76.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField76.setText(student.getCourseAt(7, 1));
        jPanel2.add(jTextField76);

        jTextField77.setEditable(false);
        jTextField77.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField77.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField77.setText(student.getCourseAt(7, 2));
        jPanel2.add(jTextField77);

        jTextField78.setEditable(false);
        jTextField78.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField78.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField78.setText(student.getCourseAt(7, 3));
        jPanel2.add(jTextField78);

        jTextField79.setEditable(false);
        jTextField79.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField79.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField79.setText(student.getCourseAt(7, 4));
        jPanel2.add(jTextField79);

        jTextField80.setEditable(false);
        jTextField80.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField80.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField80.setText(student.getCourseAt(7, 5));
        jPanel2.add(jTextField80);

        jTextField81.setEditable(false);
        jTextField81.setBackground(new java.awt.Color(173, 112, 96));
        jTextField81.setFont(new java.awt.Font("PT Sans Caption", 1, 12));
        jTextField81.setForeground(new java.awt.Color(220, 172, 146));
        jTextField81.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField81.setText("16.30-17.20");
        jPanel2.add(jTextField81);

        jTextField82.setEditable(false);
        jTextField82.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField82.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField82.setText(student.getCourseAt(8, 1));
        jPanel2.add(jTextField82);

        jTextField83.setEditable(false);
        jTextField83.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField83.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField83.setText(student.getCourseAt(8, 2));
        jPanel2.add(jTextField83);

        jTextField84.setEditable(false);
        jTextField84.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField84.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField84.setText(student.getCourseAt(8, 3));
        jPanel2.add(jTextField84);

        jTextField85.setEditable(false);
        jTextField85.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField85.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField85.setText(student.getCourseAt(8, 4));
        jPanel2.add(jTextField85);

        jTextField86.setEditable(false);
        jTextField86.setFont(new java.awt.Font("PT Sans Caption", 1, 20));
        jTextField86.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField86.setText(student.getCourseAt(8, 5));
        jPanel2.add(jTextField86);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 60, 730, 650);

        jButtonSectionChange.setBackground(new java.awt.Color(220, 172, 146));
        jButtonSectionChange.setFont(new java.awt.Font("Bahnschrift", 1, 24));
        jButtonSectionChange.setForeground(new java.awt.Color(172, 112, 96));
        jButtonSectionChange.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button1.png"));
        jButtonSectionChange.setText("SINGLE SECTION CHANGE");
        jButtonSectionChange.setToolTipText("");
        jButtonSectionChange.setBorder(null);
        jButtonSectionChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSectionChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSectionChange.addActionListener(evt -> jButtonSectionChangeActionPerformed());
        jPanel1.add(jButtonSectionChange);
        jButtonSectionChange.setBounds(790, 100, 460, 160);

        jButtonForum.setBackground(new java.awt.Color(220, 172, 146));
        jButtonForum.setFont(new java.awt.Font("Bahnschrift", 1, 24));
        jButtonForum.setForeground(new java.awt.Color(172, 112, 96));
        jButtonForum.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button1.png"));
        jButtonForum.setText("FORUM");
        jButtonForum.setToolTipText("");
        jButtonForum.setBorder(null);
        jButtonForum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonForum.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonForum.addActionListener(evt -> jButtonForumActionPerformed());
        jPanel1.add(jButtonForum);
        jButtonForum.setBounds(790, 520, 460, 160);

        jLabelClose.setFont(new java.awt.Font("Lucida Handwriting", 1, 48));
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked();
            }
        });
        jPanel1.add(jLabelClose);
        jLabelClose.setBounds(1230, 0, 32, 58);

        jButtonMultiChange.setBackground(new java.awt.Color(220, 172, 146));
        jButtonMultiChange.setFont(new java.awt.Font("Bahnschrift", 1, 24));
        jButtonMultiChange.setForeground(new java.awt.Color(172, 112, 96));
        jButtonMultiChange.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button1.png"));
        jButtonMultiChange.setText("MULTIPLE-CHANGE REQUEST ");
        jButtonMultiChange.setToolTipText("");
        jButtonMultiChange.setBorder(null);
        jButtonMultiChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonMultiChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonMultiChange.addActionListener(evt -> jButtonMultiChangeActionPerformed());
        jPanel1.add(jButtonMultiChange);
        jButtonMultiChange.setBounds(790, 310, 460, 160);

        homeButton.setBackground(new java.awt.Color(220, 172, 146));
        homeButton.setForeground(new java.awt.Color(220, 172, 146));
        homeButton.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\home.png"));
        homeButton.setBorder(null);
        homeButton.addActionListener(evt -> HomeButtonActionPerformed());
        jPanel1.add(homeButton);
        homeButton.setBounds(1130, 0, 60, 50);

        jLabelMinimize.setFont(new java.awt.Font("Lucida Fax", 1, 48));
        jLabelMinimize.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.setText("-");
        jLabelMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinimizeMouseClicked();
            }
        });
        jPanel1.add(jLabelMinimize);
        jLabelMinimize.setBounds(1190, 0, 31, 58);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButtonSectionChangeActionPerformed() {
        SingleChange singleChange = new SingleChange(this.student);
        singleChange.setLocationRelativeTo(null);
        singleChange.setVisible(true);
    }

    private void jButtonForumActionPerformed() {
        Forum forumPage = new Forum(this.student, 0);
        forumPage.setVisible(true);
        forumPage.setLocationRelativeTo(null);
        this.dispose();
    }

    private void jLabelCloseMouseClicked() {
        System.exit(0);
    }

    private void jButtonMultiChangeActionPerformed() {
        MultipleChange multiChange = new MultipleChange(this.student);
        multiChange.setLocationRelativeTo(null);
        multiChange.setVisible(true);
    }

    private void HomeButtonActionPerformed() {
        SchedulePage sPage = new SchedulePage(this.student);
        this.dispose();
        sPage.setVisible(true);
    }

    private void jLabelMinimizeMouseClicked() {
        this.setState(JFrame.ICONIFIED);
    }
}
