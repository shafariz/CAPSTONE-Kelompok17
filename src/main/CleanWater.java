package main;

import view1.menuUtama; // pastikan ini sesuai nama dan paket form kamu

public class CleanWater {
    public static void main(String[] args) {
        // Set look and feel ke Nimbus agar tampilan GUI modern
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("⚠️ Gagal mengatur look and feel: " + e.getMessage());
        }

        // Jalankan tampilan utama (GUI)
        java.awt.EventQueue.invokeLater(() -> {
            new menuUtama().setVisible(true);
        });
    }
}
