package util;

import javax.swing.JOptionPane;

public class alertUtil {

    public static void success(String message) {
        JOptionPane.showMessageDialog(null, message, "Sukses", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void warning(String message) {
        JOptionPane.showMessageDialog(null, message, "Peringatan", JOptionPane.WARNING_MESSAGE);
    }

    public static void error(String message) {
        JOptionPane.showMessageDialog(null, message, "Kesalahan", JOptionPane.ERROR_MESSAGE);
    }
}
