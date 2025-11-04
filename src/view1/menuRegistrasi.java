/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view1;

import dao.daerahDao;
import java.util.List;
import javax.swing.JOptionPane;
import model.daerah;


/**
 *
 * @author ravinaeka
 */
public class menuRegistrasi extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(menuRegistrasi.class.getName());

    public menuRegistrasi() {
        initComponents();
        setLocationRelativeTo(null);
        muatDaerah();
        setResizable(false);
    }

        private void muatDaerah() {
            try {
                daerahDao dao = new daerahDao();
                List<daerah> daftarDaerah = dao.getAll();

                jComboBox1.removeAllItems();
                for (daerah d : daftarDaerah) {
                    String tampil = d.getIdDaerah() + " - " + d.getKotaKabupaten() + " (" + d.getKecamatan() + ")";
                    jComboBox1.addItem(tampil);
                }

                jComboBox1.setSelectedIndex(-1);
            } catch (Exception e) {
                System.err.println("Gagal memuat daftar daerah: " + e.getMessage());
                e.printStackTrace();
            }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel2.setText("DAFTARKAN AKUN ANDA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel3.setText("Nama:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 250, 40));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, 250, 40));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setText("No. Hp:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, -1, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 250, 40));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel7.setText("Daerah:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, -1, -1));

        jButton1.setBackground(new java.awt.Color(166, 166, 166));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 250, -1));

        jButton2.setBackground(new java.awt.Color(108, 153, 194));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton2.setText("Registrasi");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 250, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 250, 40));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 250, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view1/eimg menu registrasi.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1026, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new menuUtama().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                        
        String nama     = jTextField1.getText().trim();
        String username = jTextField2.getText().trim();
        String password = jPasswordField1.getText().trim();
        String nomorTelepon = jTextField4.getText().trim();
        String selectedItem = (String) jComboBox1.getSelectedItem(); 

        if (nama.isEmpty() || username.isEmpty() || password.isEmpty() || 
            nomorTelepon.isEmpty() || selectedItem == null) {
            JOptionPane.showMessageDialog(this, 
                "Semua kolom harus diisi!",
                "Registrasi Gagal", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idDaerah;
        try {
            idDaerah = Integer.parseInt(selectedItem.split(" - ")[0]); 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Format daerah tidak valid!",
                "Input Tidak Valid",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
            
        if (!nama.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(this,
                "Nama hanya boleh berisi huruf dan spasi!.",
                "Input Tidak Valid",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!nomorTelepon.matches("\\d{10,15}")) {
            JOptionPane.showMessageDialog(this,
                "Nomor telepon harus berisi 10-15 digit angka.",
                "Input Tidak Valid",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        dao.penggunaDao penggunaDao = new dao.penggunaDao();
        if (penggunaDao.isUsernameExist(username)) {
            JOptionPane.showMessageDialog(this,
                "Username sudah digunakan! Silakan pilih yang lain.",
                "Registrasi Gagal",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        model.Pengguna penggunaBaru = new model.Pengguna();
        penggunaBaru.setNama(nama);
        penggunaBaru.setUsername(username);
        penggunaBaru.setPassword(password);

        boolean success = penggunaDao.registerWarga(penggunaBaru, nomorTelepon, idDaerah);

        if (success) {
            JOptionPane.showMessageDialog(this,
                "Registrasi berhasil! Silakan login.",
                "Sukses",
                JOptionPane.INFORMATION_MESSAGE);

            jTextField1.setText("");
            jTextField2.setText("");
            jPasswordField1.setText("");
            jTextField4.setText("");
            jComboBox1.setSelectedIndex(-1);

            new menuUtama().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan saat registrasi.",
                "Registrasi Gagal",
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new menuRegistrasi().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
