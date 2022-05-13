package client.LoginPage;

import client.SchedulePage.SchedulePage;
import client.main.Connection;
import client.main.Student;

import javax.swing.*;

public class LoginPage extends javax.swing.JFrame {
    private javax.swing.JTextField jID;
    private javax.swing.JPasswordField jPassword;

    public LoginPage() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JButton jButtonLogin = new JButton();
        JLabel jLabelClose = new JLabel();
        JLabel jLabelMinimize = new JLabel();
        JLabel jLabelRegister = new JLabel();
        jID = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(220, 172, 146));

        jButtonLogin.setBackground(new java.awt.Color(220, 172, 146));
        jButtonLogin.setFont(new java.awt.Font("Bahnschrift", 1, 32));
        jButtonLogin.setForeground(new java.awt.Color(220, 172, 146));

        jButtonLogin.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button.png"));

        jButtonLogin.setText("Login");
        jButtonLogin.setToolTipText("");
        jButtonLogin.setBorder(null);
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    jButtonLoginMouseClicked();
                } catch (RuntimeException ignored) {
                }
            }
        });

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

        jLabelMinimize.setFont(new java.awt.Font("Lucida Handwriting", 1, 48));
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
        jLabelRegister.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\Icon.png"));
        jID.setFont(new java.awt.Font("Helvetica Neue", 3, 18));
        jID.setForeground(new java.awt.Color(212, 212, 212));
        jID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jID.setText("USER ID");
        jID.setAlignmentX(1.5F);
        jID.setBorder(javax.swing.BorderFactory.createMatteBorder(9, 9, 9, 9, new java.awt.Color(172, 112, 96)));
        jID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIDMouseClicked();
            }
        });

        jPassword.setFont(new java.awt.Font("Helvetica Neue", 3, 18));
        jPassword.setForeground(new java.awt.Color(212, 212, 212));
        jPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPassword.setText("password");
        jPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(9, 9, 9, 9, new java.awt.Color(172, 112, 96)));
        jPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordMouseClicked();
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
                                .addComponent(jLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 391, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jPassword)
                                                        .addComponent(jID, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
                                                .addGap(317, 317, 317)))
                                .addGap(141, 141, 141))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelMinimize, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(jLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
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
    }

    private void jLabelCloseMouseClicked() {
        System.exit(0);
    }

    private void jLabelMinimizeMouseClicked() {
        this.setState(JFrame.ICONIFIED);
    }

    private void jButtonLoginMouseClicked() {
        String id = jID.getText();
        if (Connection.authenticate(id, jPassword.getText())) {
            Student student = Connection.getUpdatedStudent(id);
            student.setCourseSchedule(Connection.getStudentCourseSchedule(id));
            SchedulePage sPage = new SchedulePage(student);
            sPage.setVisible(true);
            this.dispose();
        }
    }

    private void jIDMouseClicked() {
        jID.setText("");
    }

    private void jPasswordMouseClicked() {
        jPassword.setText("");
    }
}
