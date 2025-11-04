/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view1;

import dao.distribusiAirDao;
import dao.kualitasAirDao;
import dao.laporanDao;
import dao.sumberAirDao;
import model.distribusiAir;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import model.laporan1;
import model.sumberAir;


/**
 *
 * @author ravinaeka
 */
public class formDistribusiAir extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(formDistribusiAir.class.getName());
    private int idLaporanTerkait;
    private String namaWarga;
    private String kabupaten;
    private String kecamatan;
    private int idDaerahLaporan;

    /**
     * Creates new form formDistribusiAir
     * @throws java.sql.SQLException
     */
    public formDistribusiAir() throws SQLException {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        addPlaceholder(jTextField3, "YYYY-MM-DD");
        isiComboBoxSumberAir();
        muatDataDistribusi();
    }
 
public void setDataLaporan(int idLaporan, String namaWarga, String kabupaten, String kecamatan) {
        try {
            this.idLaporanTerkait = idLaporan;
            this.namaWarga = namaWarga;
            this.kabupaten = kabupaten;
            this.kecamatan = kecamatan;
                
            dao.daerahDao daerahDao = new dao.daerahDao();
            model.daerah daerahObj = daerahDao.getByNama(kabupaten, kecamatan);
            if (daerahObj != null) {
                this.idDaerahLaporan = daerahObj.getIdDaerah();
                System.out.println("🟢 ID daerah laporan: " + idDaerahLaporan);
            } else {
                System.err.println("⚠️ Tidak menemukan daerah untuk laporan ini");
            }
        } catch (SQLException ex) {
            System.getLogger(formDistribusiAir.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
}

    private void isiComboBoxSumberAir() throws SQLException {
    try {
        sumberAirDao dao = new sumberAirDao();
        List<sumberAir> daftarSumber = dao.getAll();
        jComboBox1.removeAllItems();
        for (sumberAir s : daftarSumber) {
            jComboBox1.addItem(s.getIdSumber() + " - " + s.getNamaSumber());
        }
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Gagal memuat data sumber air:\n" + e.getMessage(),
            "Kesalahan Database",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    private void muatDataDistribusi() {
        try {
        distribusiAirDao dao = new distribusiAirDao();
        List<distribusiAir> daftarDistribusi = dao.getAll();

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID Distribusi", "ID Sumber", "Tanggal Distribusi", "Volume Distribusi"}, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (distribusiAir d : daftarDistribusi) {
            model.addRow(new Object[]{
                d.getIdDistribusi(),
                d.getIdSumber(),
                d.getTanggalDistribusi(),
                (long) d.getVolumeDistribusi()
            });
        }

        jTable1.setModel(model);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);

        javax.swing.table.TableRowSorter<javax.swing.table.DefaultTableModel> sorter =
                new javax.swing.table.TableRowSorter<>(model);
        jTable1.setRowSorter(sorter);

    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this,
            "Gagal memuat data distribusi:\n" + e.getMessage(),
            "Kesalahan Database",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private void addPlaceholder(javax.swing.JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(java.awt.Color.GRAY);

        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(java.awt.Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(java.awt.Color.GRAY);
                }
            }
        });
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel2.setText("DISTRIBUSI AIR");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(166, 166, 166));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 540, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID ", "ID Sumber", "Kecamatan", "Tanggal", "Volume "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 187, 490, 340));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel3.setText("Pilih Sumber Air :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel4.setText("Tanggal:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 140, 30));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel5.setText("Volume:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, -1, -1));

        jTextField3.setForeground(new java.awt.Color(128, 128, 128));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 140, 30));

        jButton2.setBackground(new java.awt.Color(108, 153, 194));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton2.setText("Distribusikan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 170, -1));

        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 330, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view1/eimg form distribusi air.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1026, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new menuAdmin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                        
        try {
            if (jComboBox1.getSelectedItem() == null) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Pilih sumber air terlebih dahulu!",
                    "Input Tidak Lengkap",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            String selected = jComboBox1.getSelectedItem().toString();
            int idSumber = Integer.parseInt(selected.split(" - ")[0]);
            String inputTanggal = jTextField3.getText().trim();
            String inputVolume = jTextField2.getText().trim();

            if (inputTanggal.isEmpty() || inputVolume.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Field tanggal dan volume tidak boleh kosong!",
                    "Input Tidak Lengkap",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            long volume;
            try {
                volume = Long.parseLong(inputVolume);
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Volume harus berupa angka bulat (tanpa huruf atau simbol).",
                    "Kesalahan Input",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            Date tanggal;
            try {
                java.time.LocalDate parsedDate = java.time.LocalDate.parse(inputTanggal);
                tanggal = Date.valueOf(parsedDate);

                if (parsedDate.isBefore(java.time.LocalDate.now())) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                        "Tanggal distribusi tidak boleh di masa lalu!",
                        "Kesalahan Tanggal",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }
            } catch (java.time.format.DateTimeParseException e) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Format tanggal salah! Gunakan format: YYYY-MM-DD\nContoh: 2025-12-20",
                    "Kesalahan Format Tanggal",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (volume < 10000) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Volume distribusi minimal adalah 10.000 liter.",
                    "Volume Terlalu Kecil",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            dao.sumberAirDao daoSumber = new dao.sumberAirDao();
            model.sumberAir sumber = daoSumber.getById(idSumber);
            if (sumber == null) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Data sumber air tidak ditemukan!",
                    "Kesalahan Data",
                    javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!"Aktif".equalsIgnoreCase(sumber.getStatus())) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Sumber air \"" + sumber.getNamaSumber() + "\" sedang tidak aktif.\nDistribusi dibatalkan.",
                    "Sumber Tidak Aktif",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            dao.kualitasAirDao daoKualitas = new dao.kualitasAirDao();
            model.kualitasAir hasilUji = daoKualitas.getTerbaruBySumberId(idSumber);

            if (hasilUji == null) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Belum ada data uji kualitas untuk sumber ini.\nDistribusi tidak dapat dilakukan.",
                    "Data Kualitas Tidak Ada",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }
        String statusKelayakan = hasilUji.getStatusKelayakan();
        Date tanggalUjiTerakhir = hasilUji.getTanggalUji();

        System.out.println("DEBUG: status terakhir = " + statusKelayakan + ", tanggal uji terakhir = " + tanggalUjiTerakhir);

        if (statusKelayakan == null || !"Layak".equalsIgnoreCase(statusKelayakan.trim())) {
            String tampilStatus = (statusKelayakan == null || statusKelayakan.trim().isEmpty())
                    ? "Tidak Diketahui"
                    : statusKelayakan;

            javax.swing.JOptionPane.showMessageDialog(this,
                "Kualitas air dari sumber \"" + sumber.getNamaSumber() + "\" TIDAK LAYAK untuk distribusi!\n\n" +
                "Status terakhir: " + tampilStatus + "\n" +
                "Tanggal uji terakhir: " + tanggalUjiTerakhir,
                "Kualitas Tidak Layak",
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (tanggal.before(tanggalUjiTerakhir)) {
            javax.swing.JOptionPane.showMessageDialog(this,
                """
                Tanggal distribusi tidak boleh sebelum tanggal uji terakhir!
                Tanggal uji terakhir: """ + tanggalUjiTerakhir,
                "Kesalahan Tanggal",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;

            }
            
            model.distribusiAir d = new model.distribusiAir();
            d.setIdSumber(idSumber);
            d.setVolumeDistribusi(volume);
            d.setTanggalDistribusi(tanggal);
            d.setIdDaerah(idDaerahLaporan);

            dao.distribusiAirDao daoDistribusi = new dao.distribusiAirDao();
            daoDistribusi.insert(d);

            if (idLaporanTerkait > 0) {
            dao.laporanDao daoLaporan = new dao.laporanDao();
            boolean sukses = daoLaporan.updateStatusLaporan(idLaporanTerkait, "Sudah Ditindak");

            if (sukses) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Laporan warga \"" + namaWarga + "\" telah ditandai sebagai *Sudah Ditindak*.",
                    "Laporan Ditindak",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "Distribusi berhasil, tapi status laporan gagal diperbarui.",
                    "Peringatan",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        }


            javax.swing.JOptionPane.showMessageDialog(this,
                """
                Distribusi air berhasil dilakukan!
                
                Sumber: """ + sumber.getNamaSumber() + "\n" +
                "Tanggal: " + tanggal + "\n" +
                "Volume: " + volume + " liter",
                "Distribusi Sukses",
                javax.swing.JOptionPane.INFORMATION_MESSAGE);

            muatDataDistribusi();
            jTextField2.setText("");
            jTextField3.setText("YYYY-MM-DD");
            jTextField3.setForeground(java.awt.Color.GRAY);

        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Terjadi kesalahan database: " + ex.getMessage(),
                "Kesalahan Database",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed

    }//GEN-LAST:event_jTextField3ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new formDistribusiAir().setVisible(true);
            } catch (SQLException ex) {
                System.getLogger(formDistribusiAir.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
