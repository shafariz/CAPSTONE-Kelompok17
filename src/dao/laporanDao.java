package dao;

import dao.interfaces.iLaporanDao;
import model.laporan1;
import service.databaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class laporanDao implements iLaporanDao {

    private final Connection conn;

    public laporanDao() {
        conn = databaseConnection.getConnection();
    }

    @Override
    public void insert(laporan1 l) {
        String sql = "INSERT INTO laporan (id_pengguna, id_daerah, tanggal_laporan, deskripsi, status) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, l.getIdPengguna());     
            stmt.setInt(2, l.getIdDaerah());      
            stmt.setDate(3, l.getTanggalLaporan());
            stmt.setString(4, l.getDeskripsi());
            stmt.setString(5, l.getStatus());
            stmt.executeUpdate();

            System.out.println("✅ Laporan baru berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("❌ Gagal menambahkan laporan: " + e.getMessage());
        }
    }

    @Override
public List<laporan1> getAll() {
    List<laporan1> list = new ArrayList<>();
    String sql = """
    SELECT l.id_laporan, 
           COALESCE(p.nama, '-') AS nama,
           COALESCE(d.kotakabupaten, '-') AS kotakabupaten,
           COALESCE(d.kecamatan, '-') AS kecamatan,
           l.tanggal_laporan, 
           l.deskripsi, 
           l.status
    FROM laporan l
    LEFT JOIN pengguna p ON l.id_pengguna = p.id_pengguna
    LEFT JOIN daerah d ON l.id_daerah = d.id_daerah
    ORDER BY l.id_laporan ASC
""";


    try (Connection conn = databaseConnection.getConnection();
     PreparedStatement stmt = conn.prepareStatement(sql);
     ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
        laporan1 l = new laporan1();
        l.setIdLaporan(rs.getInt("id_laporan"));
        l.setNamaPengguna(rs.getString("nama"));
        l.setKotaKabupaten(rs.getString("kotakabupaten"));
        l.setKecamatan(rs.getString("kecamatan"));
        l.setTanggalLaporan(rs.getDate("tanggal_laporan"));
        l.setDeskripsi(rs.getString("deskripsi"));
        l.setStatus(rs.getString("status"));
        list.add(l);
    }
    } catch (SQLException e) {
        System.err.println("❌ Gagal memuat laporan: " + e.getMessage());
    }
    return list;
}

    public void updateStatus(int idLaporan, String statusBaru) {
        String sql = "UPDATE laporan SET status = ? WHERE id_laporan = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, statusBaru);
            stmt.setInt(2, idLaporan);
            stmt.executeUpdate();
            System.out.println("✅ Status laporan ID " + idLaporan + " diperbarui menjadi " + statusBaru);
        } catch (SQLException e) {
            System.err.println("❌ Gagal memperbarui status laporan: " + e.getMessage());
        }
    }
    
        public boolean updateStatusLaporan(int idLaporan, String statusBaru) {
        String sql = "UPDATE laporan SET status = ? WHERE id_laporan = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, statusBaru);
            stmt.setInt(2, idLaporan);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("❌ Gagal memperbarui status laporan: " + e.getMessage());
            return false;
        }
    }
public int getIdDaerahByWarga(int idWarga) {
    String sql = """
        SELECT id_daerah 
        FROM laporan 
        WHERE id_pengguna = ? 
        ORDER BY id_laporan DESC 
        LIMIT 1
    """;

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, idWarga);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_daerah");
            }
        }
    } catch (SQLException e) {
        System.err.println("❌ Gagal mengambil id_daerah dari warga: " + e.getMessage());
    }
    return 0;
}


}
