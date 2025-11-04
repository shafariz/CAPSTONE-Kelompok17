package controller;

import dao.penggunaDao;
import model.Pengguna;
import java.util.List;

public class authController {
    private final penggunaDao dao;

    public authController() {
        this.dao = new penggunaDao();
    }

    public Pengguna login(String username, String password) {
    Pengguna p = dao.login(username, password);

    if (p != null) {
        System.out.println("Login berhasil sebagai: " + p.getNama());

        try {
            view1.menuWarga.idWargaLogin = p.getIdPengguna();
            view1.menuWarga.idDaerahWarga = p.getIdDaerah();
            System.out.println("→ ID Warga Login: " + p.getIdPengguna());
            System.out.println("→ ID Daerah Warga: " + p.getIdDaerah());
        } catch (Exception e) {
            System.err.println("⚠️ Gagal menyimpan data login ke menuWarga: " + e.getMessage());
        }

        return p;
    }

    System.out.println("Login gagal, username atau password salah.");
    return null;
}

    public boolean registrasi(Pengguna baru) {
        if (baru.getNama().isEmpty() || baru.getUsername().isEmpty() || baru.getPassword().isEmpty()) {
            System.err.println("⚠️ Data tidak lengkap saat registrasi.");
            return false;
        }
        try {
            dao.insert(baru);
            System.out.println("Registrasi berhasil untuk: " + baru.getUsername());
            return true;
        } catch (Exception e) {
            System.err.println("Gagal registrasi: " + e.getMessage());
            return false;
        }
    }
}
