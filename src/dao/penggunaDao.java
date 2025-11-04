package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Pengguna;
import model.Warga;
import model.Admin;
import service.databaseConnection;

public class penggunaDao implements dao.interfaces.iPenggunaDao {

    @Override
    public void insert(Pengguna pengguna) throws SQLException {
        String sql = "INSERT INTO pengguna (nama, username, password) VALUES (?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pengguna.getNama());
            ps.setString(2, pengguna.getUsername());
            ps.setString(3, pengguna.getPassword());
            ps.executeUpdate();
        }
    }

    @Override
    public Pengguna findByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM pengguna WHERE username = ?";
        Pengguna pengguna = null;
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pengguna = new Pengguna();
                    pengguna.setIdPengguna(rs.getInt("id_pengguna"));
                    pengguna.setNama(rs.getString("nama"));
                    pengguna.setUsername(rs.getString("username"));
                    pengguna.setPassword(rs.getString("password"));
                }
            }
        }
        return pengguna;
    }

    @Override
    public List<Pengguna> getAll() throws SQLException {
        List<Pengguna> list = new ArrayList<>();
        String sql = "SELECT * FROM pengguna";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pengguna p = new Pengguna();
                p.setIdPengguna(rs.getInt("id_pengguna"));
                p.setNama(rs.getString("nama"));
                p.setUsername(rs.getString("username"));
                p.setPassword(rs.getString("password"));
                list.add(p);
            }
        }
        return list;
    }

    // 🔹 Tambahan method khusus login
    public Pengguna login(String username, String password) {
        Pengguna pengguna = null;

        try (Connection conn = databaseConnection.getConnection()) {
            String sqlUser = "SELECT * FROM pengguna WHERE username = ? AND password = ?";
            PreparedStatement psUser = conn.prepareStatement(sqlUser);
            psUser.setString(1, username);
            psUser.setString(2, password);
            ResultSet rsUser = psUser.executeQuery();

            if (rsUser.next()) {
                int idPengguna = rsUser.getInt("id_pengguna");
                String nama = rsUser.getString("nama");

                // Cek apakah pengguna admin
                String sqlAdmin = "SELECT * FROM admin WHERE id_pengguna = ?";
                PreparedStatement psAdmin = conn.prepareStatement(sqlAdmin);
                psAdmin.setInt(1, idPengguna);
                ResultSet rsAdmin = psAdmin.executeQuery();

                if (rsAdmin.next()) {
                    Admin admin = new Admin();
                    admin.setIdPengguna(idPengguna);
                    admin.setNama(nama);
                    admin.setUsername(username);
                    admin.setPassword(password);
                    admin.setEmail(rsAdmin.getString("email"));
                    pengguna = admin;
                    System.out.println("🔐 Login sebagai ADMIN: " + admin.getNama());
                } else {
                    // Jika bukan admin, cek tabel warga
                    String sqlWarga = "SELECT * FROM warga WHERE id_pengguna = ?";
                    PreparedStatement psWarga = conn.prepareStatement(sqlWarga);
                    psWarga.setInt(1, idPengguna);
                    ResultSet rsWarga = psWarga.executeQuery();

                    if (rsWarga.next()) {
                        Warga warga = new Warga();
                        warga.setIdPengguna(idPengguna);
                        warga.setNama(nama);
                        warga.setUsername(username);
                        warga.setPassword(password);
                        warga.setNomorTelepon(rsWarga.getString("nomor_telepon"));
                        warga.setIdDaerah(rsWarga.getInt("id_daerah"));
                        pengguna = warga;

                        System.out.println("✅ Login sebagai WARGA: " + warga.getNama());
                    } else {
                        System.out.println("⚠️ Pengguna bukan admin maupun warga.");
                    }
                }
            } else {
                System.out.println("❌ Username atau password salah.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Kesalahan saat login:\n" + e.getMessage(),
                "Database Error",
                JOptionPane.ERROR_MESSAGE);
        }

        return pengguna;
    }

    // 🔹 Tambahan method register warga
    public boolean registerWarga(Pengguna pengguna, String nomorTelepon, int idDaerah) {
        String insertPengguna = "INSERT INTO pengguna (nama, username, password) VALUES (?, ?, ?)";
        String insertWarga = "INSERT INTO warga (id_pengguna, id_daerah, nomor_telepon) VALUES (?, ?, ?)";

        try (Connection conn = databaseConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement psPengguna = conn.prepareStatement(insertPengguna, Statement.RETURN_GENERATED_KEYS)) {
                psPengguna.setString(1, pengguna.getNama());
                psPengguna.setString(2, pengguna.getUsername());
                psPengguna.setString(3, pengguna.getPassword());
                psPengguna.executeUpdate();

                try (ResultSet rsKeys = psPengguna.getGeneratedKeys()) {
                    if (rsKeys.next()) {
                        int idPenggunaBaru = rsKeys.getInt(1);
                        try (PreparedStatement psWarga = conn.prepareStatement(insertWarga)) {
                            psWarga.setInt(1, idPenggunaBaru);
                            psWarga.setInt(2, idDaerah);
                            psWarga.setString(3, nomorTelepon);
                            psWarga.executeUpdate();
                        }
                    } else {
                        throw new SQLException("Gagal mengambil ID pengguna baru.");
                    }
                }

                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 🔹 Tambahan method untuk cek username
    public boolean isUsernameExist(String username) {
        String sql = "SELECT COUNT(*) FROM pengguna WHERE username = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
