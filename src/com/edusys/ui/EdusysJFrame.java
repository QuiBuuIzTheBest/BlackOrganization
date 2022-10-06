/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.ui;

import com.edusys.utils.Auth;
import com.edusys.utils.XImage;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EdusysJFrame extends javax.swing.JFrame {

    public EdusysJFrame(String userID, String role, String ngDung ) {
        initComponents();
        init();
        checkDangNhap(userID,role,ngDung);
        setIconImage(XImage.AppIcon);
    }

    public void init() {
        new ChaoJDialog(this, rootPaneCheckingEnabled).setVisible(true);
        startDongHo();
    }

    public void checkDangNhap(String userID, String role, String ngDung){
        if (ngDung.equals("")) {
            lblInfo.setText("Khách");
            btnLogout.setEnabled(false);
            btnExit.setEnabled(false);
            btnChuyenDe.setEnabled(false);
            btnNguoiHoc.setEnabled(false);
            btnKhoaHoc.setEnabled(false);
            mniChangePassword.setEnabled(false);
            mnuQuanLy.setEnabled(false);
            mniLogout.setEnabled(false);
            mniLogin.setEnabled(true);
        } else {
            if (role.equals("Nhân Viên")) {
                mniThongKe.setEnabled(false);
                mniNhanVien.setEnabled(false);
            } else {
                mniThongKe.setEnabled(true);
                mniNhanVien.setEnabled(true);
            }
            lblInfo.setText(ngDung + " (" + role + ")");
            btnLogout.setEnabled(true);
            btnExit.setEnabled(true);
            btnChuyenDe.setEnabled(true);
            btnNguoiHoc.setEnabled(true);
            btnKhoaHoc.setEnabled(true);
            mniChangePassword.setEnabled(true);
            mnuQuanLy.setEnabled(true);
            mniLogout.setEnabled(true);
            mniLogin.setEnabled(false);
        }
    }
    public void startDongHo() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);

                    String time = String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);

                    lblTime.setText(time);
                }
            }
        }.start();
    }

    public void openDoiMatKhau() {
        dispose();
        new DoiMatKhauJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void dangXuat() {
        int dangXuat = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn đăng xuất không ?", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (dangXuat == JOptionPane.YES_OPTION) { 
            dispose();
            new DangNhapJDialog(this, rootPaneCheckingEnabled).setVisible(true);
        }
    }

    public void ketThuc() {
        int thoat = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát không ?", "Thoát chương trình", JOptionPane.YES_NO_OPTION);
        if (thoat == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void openNhanVien() {
        dispose();
        new NhanVienJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openKhoaHoc() {
        dispose();
        new KhoaHocJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openChuyenDe() {
        dispose();
        new ChuyenDeJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openNguoiHoc() {
        dispose();
        new NguoiHocJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openHocVien() {
        dispose();
        new HocVienJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openThongKe() {
        dispose();
        new TH_TKJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openGioiThieu() {
        new GioiThieuJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    public void openHuongDan() {
        try {
            try {
                Desktop.getDesktop().browse(new URI("https://ap.poly.edu.vn/"));
            } catch (IOException ex) {
                Logger.getLogger(EdusysJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(EdusysJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openDangNhap() {
        dispose();
        new DangNhapJDialog(this, rootPaneCheckingEnabled).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        btnLogout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnChuyenDe = new javax.swing.JButton();
        btnNguoiHoc = new javax.swing.JButton();
        btnKhoaHoc = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnHuongDan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTime = new javax.swing.JLabel();
        lblInfo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniChangePassword = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniExit = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniNguoiHoc = new javax.swing.JMenuItem();
        mniChuyenDe = new javax.swing.JMenuItem();
        mniKhoaHoc = new javax.swing.JMenuItem();
        mniNhanVien = new javax.swing.JMenuItem();
        mniHocVien = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        mniThongKe = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mniHuongDan = new javax.swing.JMenuItem();
        mniGioiThieu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduSys");

        jToolBar1.setRollover(true);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Exit.png"))); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLogout);

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Stop.png"))); // NOI18N
        btnExit.setText("Kết thúc");
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExit);
        jToolBar1.add(jSeparator1);

        btnChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Lists.png"))); // NOI18N
        btnChuyenDe.setText("Chuyên đề");
        btnChuyenDe.setFocusable(false);
        btnChuyenDe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChuyenDeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnChuyenDe);

        btnNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Conference.png"))); // NOI18N
        btnNguoiHoc.setText("Người học");
        btnNguoiHoc.setFocusable(false);
        btnNguoiHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNguoiHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNguoiHoc);

        btnKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Certificate.png"))); // NOI18N
        btnKhoaHoc.setText("Khóa học");
        btnKhoaHoc.setFocusable(false);
        btnKhoaHoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhoaHocActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKhoaHoc);
        jToolBar1.add(jSeparator6);

        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Globe.png"))); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.setFocusable(false);
        btnHuongDan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHuongDan);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/logo.png"))); // NOI18N

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Clock.png"))); // NOI18N

        lblInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/User.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("Hệ thống");

        mniLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Key.png"))); // NOI18N
        mniLogin.setText("Đăng nhập");
        mniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoginActionPerformed(evt);
            }
        });
        jMenu1.add(mniLogin);

        mniLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Exit.png"))); // NOI18N
        mniLogout.setText("Đăng xuất");
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(mniLogout);
        jMenu1.add(jSeparator3);

        mniChangePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Refresh.png"))); // NOI18N
        mniChangePassword.setText("Đổi mật khẩu");
        mniChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChangePasswordActionPerformed(evt);
            }
        });
        jMenu1.add(mniChangePassword);
        jMenu1.add(jSeparator4);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Stop.png"))); // NOI18N
        mniExit.setText("Kết thúc");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        jMenu1.add(mniExit);

        jMenuBar1.add(jMenu1);

        mnuQuanLy.setText("Quản lý");

        mniNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Conference.png"))); // NOI18N
        mniNguoiHoc.setText("Người học");
        mniNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNguoiHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNguoiHoc);

        mniChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Lists.png"))); // NOI18N
        mniChuyenDe.setText("Chuyên đề");
        mniChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChuyenDeActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniChuyenDe);

        mniKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Certificate.png"))); // NOI18N
        mniKhoaHoc.setText("Khóa học");
        mniKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKhoaHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniKhoaHoc);

        mniNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/User.png"))); // NOI18N
        mniNhanVien.setText("Nhân viên");
        mniNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNhanVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNhanVien);

        mniHocVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Boy.png"))); // NOI18N
        mniHocVien.setText("Học Viên");
        mniHocVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHocVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniHocVien);
        mnuQuanLy.add(jSeparator7);

        mniThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Bar chart.png"))); // NOI18N
        mniThongKe.setText("Thống kê");
        mniThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThongKeActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniThongKe);

        jMenuBar1.add(mnuQuanLy);

        jMenu4.setText("Trợ giúp");

        mniHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Globe.png"))); // NOI18N
        mniHuongDan.setText("Hướng dẫn sử dụng");
        mniHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniHuongDanActionPerformed(evt);
            }
        });
        jMenu4.add(mniHuongDan);

        mniGioiThieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icons/Info.png"))); // NOI18N
        mniGioiThieu.setText("Giới thiệu sản phẩm");
        mniGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGioiThieuActionPerformed(evt);
            }
        });
        jMenu4.add(mniGioiThieu);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        dangXuat();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        ketThuc();
    }//GEN-LAST:event_btnExitActionPerformed

    private void mniNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNguoiHocActionPerformed
        openNguoiHoc();
    }//GEN-LAST:event_mniNguoiHocActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        ketThuc();
    }//GEN-LAST:event_mniExitActionPerformed

    private void mniChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChangePasswordActionPerformed
        openDoiMatKhau();
    }//GEN-LAST:event_mniChangePasswordActionPerformed

    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoutActionPerformed
        dangXuat();
    }//GEN-LAST:event_mniLogoutActionPerformed

    private void mniChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChuyenDeActionPerformed
        openChuyenDe();
    }//GEN-LAST:event_mniChuyenDeActionPerformed

    private void mniKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhoaHocActionPerformed
        openKhoaHoc();
    }//GEN-LAST:event_mniKhoaHocActionPerformed

    private void mniNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNhanVienActionPerformed
        openNhanVien();
    }//GEN-LAST:event_mniNhanVienActionPerformed

    private void mniThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThongKeActionPerformed
        openThongKe();
    }//GEN-LAST:event_mniThongKeActionPerformed

    private void btnChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChuyenDeActionPerformed
        openChuyenDe();
    }//GEN-LAST:event_btnChuyenDeActionPerformed

    private void btnNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNguoiHocActionPerformed
        openNguoiHoc();
    }//GEN-LAST:event_btnNguoiHocActionPerformed

    private void btnKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhoaHocActionPerformed
        openKhoaHoc();
    }//GEN-LAST:event_btnKhoaHocActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        openHuongDan();
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void mniHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHuongDanActionPerformed
        openHuongDan();
    }//GEN-LAST:event_mniHuongDanActionPerformed

    private void mniGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGioiThieuActionPerformed
        openGioiThieu();
    }//GEN-LAST:event_mniGioiThieuActionPerformed

    private void mniHocVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniHocVienActionPerformed
        openHocVien();
    }//GEN-LAST:event_mniHocVienActionPerformed

    private void mniLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoginActionPerformed
        openDangNhap();
    }//GEN-LAST:event_mniLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EdusysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdusysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdusysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdusysJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String userID = Auth.user.getMaNV();
                    String role = Auth.user.isVaiTro() ? "Quản Lý" : "Nhân Viên";
                    String ngDung = Auth.user.getHoTen();
                    new EdusysJFrame(userID, role, ngDung).setVisible(true);
                } catch (Exception e) {
                    String userID = "";
                    String role = "";
                    String ngDung = "";
                    new EdusysJFrame(userID, role, ngDung).setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenDe;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnKhoaHoc;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNguoiHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblTime;
    private javax.swing.JMenuItem mniChangePassword;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniGioiThieu;
    private javax.swing.JMenuItem mniHocVien;
    private javax.swing.JMenuItem mniHuongDan;
    private javax.swing.JMenuItem mniKhoaHoc;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    private javax.swing.JMenuItem mniNguoiHoc;
    private javax.swing.JMenuItem mniNhanVien;
    private javax.swing.JMenuItem mniThongKe;
    private javax.swing.JMenu mnuQuanLy;
    // End of variables declaration//GEN-END:variables
}
