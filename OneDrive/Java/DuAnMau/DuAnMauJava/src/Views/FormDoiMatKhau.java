/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.QuanLyNhanVien;
import Controllers.QuanLyNhanVienImplement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author NgocPJa
 */
public class FormDoiMatKhau extends javax.swing.JFrame {

    private final QuanLyNhanVien _iQuanLyNhanVien = new QuanLyNhanVienImplement();
    private static FormDoiMatKhau _formDoiMatKhau = new FormDoiMatKhau();

    /**
     * Creates new form FormDoiMatKhau
     */
    public FormDoiMatKhau() {
        setUpForm();
        if (Tags.Login._nhanVien != null) {
            txTenDangNhap.setText(Tags.Login._nhanVien.getMaNV());
            txTenDangNhap.setEditable(false);
        } else {
            Tags.MsgThongBao.alert(this, "Vui lòng đăng nhập");
            System.exit(0);
        }
    }

    private void setUpForm() {
        initComponents();
        try {
            closingForm();
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setTitle("Đổi mật khẩu");
            setLocationRelativeTo(this);
            setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closingForm() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Tags.Tab.closeTab(_formDoiMatKhau);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txTenDangNhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtMatKhauHienTai = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtXacNhanMatKhauMoi = new javax.swing.JPasswordField();
        btnHuyBo = new javax.swing.JButton();
        btnDongY = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 0));
        jLabel1.setText("Đổi mật khẩu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");

        txTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Mật khẩu mới:");

        txtMatKhauMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Mật khẩu hiện tại:");

        txtMatKhauHienTai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Xác nhận mật khẩu mới:");

        txtXacNhanMatKhauMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnHuyBo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHuyBo.setText("Hủy bỏ");
        btnHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBoActionPerformed(evt);
            }
        });

        btnDongY.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDongY.setText("Đồng ý");
        btnDongY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(txTenDangNhap)
                            .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtMatKhauHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtXacNhanMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtXacNhanMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtMatKhauHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDongY, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBoActionPerformed
        try {
            if (Tags.MsgThongBao.confirm(this, "Hủy bỏ đổi mật khẩu?")) {
                this.dispose();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHuyBoActionPerformed

    private void btnDongYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongYActionPerformed
        try {
            evtDoiiMatKhau();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDongYActionPerformed

    private void evtDoiiMatKhau() {
        String getMatKhauHienTai = new String(txtMatKhauHienTai.getText());
        String getMatKhauMoi = new String(txtMatKhauMoi.getText());
        String getXacNhanMatKhau = new String(txtXacNhanMatKhauMoi.getText());
        String thongBao = "";
        if (getMatKhauHienTai.isBlank() || getMatKhauHienTai.isEmpty()) {
            thongBao = "Chưa nhập mật khẩu hiện tại!";
        } else if (getMatKhauMoi.isBlank() || getMatKhauMoi.isEmpty()) {
            thongBao = "Chưa nhập mật khẩu mới!";
        } else if (getXacNhanMatKhau.isBlank() || getXacNhanMatKhau.isEmpty()) {
            thongBao = "Chưa nhập xác nhận mật khẩu mới!";
        } else if (getMatKhauMoi.length() < 8 || getXacNhanMatKhau.length() < 8) {
            thongBao = "Mật khẩu phải có độ dài từ 8 trở lên!";
        } else if (!Tags.Login._nhanVien.getMatKhau().equals(getMatKhauHienTai)) {
            thongBao = "Mật khẩu hiện tại không chính xác!\nMời nhập lại.";
        } else if (!getXacNhanMatKhau.equals(getMatKhauMoi)) {
            thongBao = "Mật khẩu mới không khớp nhau!\nMời nhập lại.";
        }
        if (thongBao.equals("")) {
            if (Tags.MsgThongBao.confirm(this, "Xác nhận đổi mật khẩu?")) {
                Tags.Login._nhanVien.setMatKhau(getMatKhauMoi);
                if (_iQuanLyNhanVien.doiMatKhau(Tags.Login._nhanVien)) {
                    Tags.MsgThongBao.alert(this, "Đổi mật khẩu thành công!");
                    this.dispose();
                } else {
                    Tags.MsgThongBao.alert(this, "Đổi mật khẩu thất bại!");
                }
            }
        } else {
            Tags.MsgThongBao.alert(this, thongBao);
        }
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDoiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                _formDoiMatKhau.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDongY;
    private javax.swing.JButton btnHuyBo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txTenDangNhap;
    private javax.swing.JPasswordField txtMatKhauHienTai;
    private javax.swing.JPasswordField txtMatKhauMoi;
    private javax.swing.JPasswordField txtXacNhanMatKhauMoi;
    // End of variables declaration//GEN-END:variables
}
