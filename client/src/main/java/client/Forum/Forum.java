package client.Forum;

import client.SchedulePage.SchedulePage;
import client.SingleMultipleChange.ForumRequestChange;
import client.main.Connection;
import client.main.ForumRequest;
import client.main.ForumRequestApproval;
import client.main.Student;

import javax.swing.*;
import java.util.List;

public class Forum extends javax.swing.JFrame {

    private final Student student;

    private final List<ForumRequest> forumRequests;
    private final int index;

    public Forum(Student student, int index) {
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.student = Connection.getUpdatedStudent(student.getId());
        forumRequests = Connection.getForumRequestsStudentCanAccept(this.student.getId());
        if (index<0){
            this.index = 0;
        }else if(index > forumRequests.size()){
            this.index = index - 5;
        }else {
            this.index = index;
        }
        initComponents();
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabelMinimize = new JLabel();
        JLabel jLabelClose = new JLabel();
        JButton jHomeButton = new JButton();
        JButton jForumAcceptButton5 = new JButton();
        JLabel jLabel1 = new JLabel();
        JButton jForumAcceptButton3 = new JButton();
        JButton jForumAcceptButton2 = new JButton();
        JTextField forum2 = new JTextField();
        JTextField forum3 = new JTextField();
        JTextField forum1 = new JTextField();
        JButton jForumAcceptButton4 = new JButton();
        JTextField forum4 = new JTextField();
        JTextField forum5 = new JTextField();
        JButton jForumAcceptButton1 = new JButton();
        JButton jButton2 = new JButton();
        JButton jButton3 = new JButton();
        JButton jButtonSectionChange = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1268, 720));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1268, 720));

        jPanel1.setBackground(new java.awt.Color(220, 172, 146));

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

        jHomeButton.setBackground(new java.awt.Color(220, 172, 146));
        jHomeButton.setForeground(new java.awt.Color(220, 172, 146));
        jHomeButton.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\home.png"));
        jHomeButton.setBorder(null);
        jHomeButton.addActionListener(this::jHomeButtonActionPerformed);

        jForumAcceptButton5.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton5.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\accept.png"));
        jForumAcceptButton5.setBorder(null);
        jForumAcceptButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForumAcceptButton5MouseClicked();
            }
        });

        jLabel1.setBackground(new java.awt.Color(173, 112, 96));
        jLabel1.setFont(new java.awt.Font("PT Sans Caption", 1, 90));
        jLabel1.setForeground(new java.awt.Color(173, 112, 96));
        jLabel1.setText("FORUM");

        jForumAcceptButton3.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton3.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\accept.png"));
        jForumAcceptButton3.setBorder(null);
        jForumAcceptButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForumAcceptButton3MouseClicked();
            }
        });

        jForumAcceptButton2.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton2.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\accept.png"));
        jForumAcceptButton2.setBorder(null);
        jForumAcceptButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForumAcceptButton2MouseClicked();
            }
        });

        forum2.setEditable(false);
        forum2.setFont(new java.awt.Font("Bahnschrift", 1, 30));
        forum2.setForeground(new java.awt.Color(220, 172, 146));
        if (forumRequests.size()>index+2) {
            forum2.setText(forumRequests.get(index+2).getCurrentCourse().getId() + "--->" + forumRequests.get(index+2).getWantedCourse().getId());
        }else{
            forum2.setText("");
        }
        forum2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        forum3.setEditable(false);
        forum3.setFont(new java.awt.Font("Bahnschrift", 1, 30));
        forum3.setForeground(new java.awt.Color(220, 172, 146));
        if (forumRequests.size()>index+4) {
            forum3.setText(forumRequests.get(index+4).getCurrentCourse().getId() + "--->" + forumRequests.get(index+4).getWantedCourse().getId());
        }else{
            forum3.setText("");
        }
        forum3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        forum1.setEditable(false);
        forum1.setFont(new java.awt.Font("Bahnschrift", 1, 30));
        forum1.setForeground(new java.awt.Color(220, 172, 146));
        if (forumRequests.size()>index+1) {
            forum1.setText(forumRequests.get(index+1).getCurrentCourse().getId() + "--->" + forumRequests.get(index+1).getWantedCourse().getId());
        }else{
            forum1.setText("");
        }
        forum1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jForumAcceptButton4.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton4.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\accept.png"));
        jForumAcceptButton4.setBorder(null);
        jForumAcceptButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForumAcceptButton4MouseClicked();
            }
        });

        forum4.setEditable(false);
        forum4.setFont(new java.awt.Font("Bahnschrift", 1, 30));
        forum4.setForeground(new java.awt.Color(220, 172, 146));
        if (forumRequests.size()>index+3) {
            forum4.setText(forumRequests.get(index+3).getCurrentCourse().getId() + "--->" + forumRequests.get(index+3).getWantedCourse().getId());
        }else{
            forum4.setText("");
        }
        forum4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        forum5.setEditable(false);
        forum5.setFont(new java.awt.Font("Bahnschrift", 1, 30));
        forum5.setForeground(new java.awt.Color(220, 172, 146));
        if (forumRequests.size()>index) {
            forum5.setText(forumRequests.get(index).getCurrentCourse().getId() + "--->" + forumRequests.get(index).getWantedCourse().getId());
        }else{
            forum5.setText("");
        }
        forum5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jForumAcceptButton1.setBackground(new java.awt.Color(220, 172, 146));
        jForumAcceptButton1.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\accept.png"));
        jForumAcceptButton1.setBorder(null);
        jForumAcceptButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForumAcceptButton1MouseClicked();
            }
        });

        jButton2.setBackground(new java.awt.Color(220, 172, 146));
        jButton2.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\arrow_reverse.png"));
        jButton2.setBorder(null);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked();
            }
        });

        jButton3.setBackground(new java.awt.Color(220, 172, 146));
        jButton3.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\arrow.png"));
        jButton3.setBorder(null);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked();
            }
        });

        jButtonSectionChange.setBackground(new java.awt.Color(220, 172, 146));
        jButtonSectionChange.setFont(new java.awt.Font("Bahnschrift", 1, 24));
        jButtonSectionChange.setForeground(new java.awt.Color(172, 112, 96));
        jButtonSectionChange.setIcon(new javax.swing.ImageIcon("D:\\cs102\\Bilkent-Section-Change-Project\\JavaApplication1\\src\\main\\resources\\button.png"));
        jButtonSectionChange.setText("FORUM REQUEST");
        jButtonSectionChange.setToolTipText("");
        jButtonSectionChange.setBorder(null);
        jButtonSectionChange.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSectionChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSectionChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSectionChangeMouseClicked();
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
                                                                                .addComponent(jHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                                .addComponent(jHomeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    }

    private void jButton3MouseClicked() {
        Forum forum = new Forum(student, index + 5);
        forum.setVisible(true);
        forum.setLocationRelativeTo(null);
        this.dispose();
    }

    private void jButton2MouseClicked() {
        Forum forum = new Forum(student, index - 5);
        forum.setVisible(true);
        forum.setLocationRelativeTo(null);
        this.dispose();
    }

    private void jButtonSectionChangeMouseClicked() {
        ForumRequestChange forumRequestChange = new ForumRequestChange(student);
        forumRequestChange.setLocationRelativeTo(null);
        forumRequestChange.setVisible(true);

    }

    private void jForumAcceptButton1MouseClicked() {
        try {
            Connection.sendForumRequestApproval(new ForumRequestApproval(forumRequests.get(index), student.getId()));
            Forum forum = new Forum(student, index);
            forum.setVisible(true);
            forum.setLocationRelativeTo(null);
            this.dispose();
        }catch (Exception ignored){}
    }

    private void jForumAcceptButton2MouseClicked() {
        try {
            Connection.sendForumRequestApproval(new ForumRequestApproval(forumRequests.get(index+1), student.getId()));
            Forum forum = new Forum(student, index);
            forum.setVisible(true);
            forum.setLocationRelativeTo(null);
            this.dispose();
        }catch (Exception ignored){}
    }

    private void jForumAcceptButton3MouseClicked() {
        try {
            Connection.sendForumRequestApproval(new ForumRequestApproval(forumRequests.get(index+2), student.getId()));
            Forum forum = new Forum(student, index);
            forum.setVisible(true);
            forum.setLocationRelativeTo(null);
            this.dispose();
        }catch (Exception ignored){}
    }

    private void jForumAcceptButton4MouseClicked() {
        try {
            Connection.sendForumRequestApproval(new ForumRequestApproval(forumRequests.get(index+3), student.getId()));
            Forum forum = new Forum(student, index);
            forum.setVisible(true);
            forum.setLocationRelativeTo(null);
            this.dispose();
        }catch (Exception ignored){}
    }

    private void jForumAcceptButton5MouseClicked() {
        try {
            Connection.sendForumRequestApproval(new ForumRequestApproval(forumRequests.get(index+4), student.getId()));
            Forum forum = new Forum(student, index);
            forum.setVisible(true);
            forum.setLocationRelativeTo(null);
            this.dispose();
        }catch (Exception ignored){}
    }

    private void jLabelMinimizeMouseClicked() {
        this.setState(JFrame.ICONIFIED);
    }

    private void jLabelCloseMouseClicked() {
        System.exit(0);
    }

    private void jHomeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SchedulePage sPage = new SchedulePage(this.student);
        sPage.setVisible(true);
        this.dispose();
    }
}
