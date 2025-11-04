package dao;

import dao.interfaces.iKualitasAirDao;
import model.kualitasAir;
import service.databaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class kualitasAirDao implements iKualitasAirDao {

    private final Connection conn;

    public kualitasAirDao() {
        conn = databaseConnection.getConnection();
    }

    @Override
    public void insert(kualitasAir kualitas) throws SQLException {
        String sql = "INSERT INTO kualitas_air (tanggal_uji, ph, status_kelayakan, id_sumber) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, kualitas.getTanggalUji());
            stmt.setDouble(2, kualitas.getPh());
            stmt.setString(3, kualitas.getStatusKelayakan());
            stmt.setInt(4, kualitas.getIdSumber());
            stmt.executeUpdate();
            System.out.println("✅ Data kualitas air berhasil ditambahkan.");
        } catch (SQLException e) {
            System.err.println("❌ Gagal menambahkan data kualitas air: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<kualitasAir> getAll() throws SQLException {
        List<kualitasAir> list = new ArrayList<>();
        String sql = """
            SELECT k.id_kualitas, k.tanggal_uji, k.ph, k.status_kelayakan, k.id_sumber, s.nama_sumber
            FROM kualitas_air k
            JOIN sumber_air s ON k.id_sumber = s.id_sumber
            ORDER BY k.id_kualitas ASC
        """;

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                kualitasAir k = new kualitasAir();
                k.setIdKualitas(rs.getInt("id_kualitas"));
                k.setTanggalUji(rs.getDate("tanggal_uji"));
                k.setPh(rs.getDouble("ph"));
                k.setStatusKelayakan(rs.getString("status_kelayakan"));
                k.setIdSumber(rs.getInt("id_sumber"));
                try {
                    // opsional, jika model punya setNamaSumber()
                    k.getClass().getMethod("setNamaSumber", String.class)
                            .invoke(k, rs.getString("nama_sumber"));
                } catch (ReflectiveOperationException ignore) {}
                list.add(k);
            }

        } catch (SQLException e) {
            System.err.println("❌ Gagal memuat semua data kualitas air: " + e.getMessage());
            throw e;
        }

        return list;
    }

    @Override
    public List<kualitasAir> getBySumber(int idSumber) throws SQLException {
        List<kualitasAir> list = new ArrayList<>();
        String sql = """
            SELECT k.id_kualitas, k.tanggal_uji, k.ph, k.status_kelayakan, k.id_sumber, s.nama_sumber
            FROM kualitas_air k
            JOIN sumber_air s ON k.id_sumber = s.id_sumber
            WHERE k.id_sumber = ?
            ORDER BY k.tanggal_uji DESC
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSumber);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    kualitasAir k = new kualitasAir();
                    k.setIdKualitas(rs.getInt("id_kualitas"));
                    k.setTanggalUji(rs.getDate("tanggal_uji"));
                    k.setPh(rs.getDouble("ph"));
                    k.setStatusKelayakan(rs.getString("status_kelayakan"));
                    k.setIdSumber(rs.getInt("id_sumber"));
                    try {
                        k.getClass().getMethod("setNamaSumber", String.class)
                                .invoke(k, rs.getString("nama_sumber"));
                    } catch (ReflectiveOperationException ignore) {}
                    list.add(k);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Gagal memuat data kualitas air berdasarkan sumber: " + e.getMessage());
            throw e;
        }

        return list;
    }

    @Override
    public kualitasAir getTerbaruBySumberId(int idSumber) throws SQLException {
        kualitasAir k = null;
        String sql = """
            SELECT * FROM kualitas_air
            WHERE id_sumber = ?
            ORDER BY tanggal_uji DESC, id_kualitas DESC
            LIMIT 1
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idSumber);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    k = new kualitasAir();
                    k.setIdKualitas(rs.getInt("id_kualitas"));
                    k.setTanggalUji(rs.getDate("tanggal_uji"));
                    k.setPh(rs.getDouble("ph"));
                    k.setStatusKelayakan(rs.getString("status_kelayakan"));
                    k.setIdSumber(rs.getInt("id_sumber"));

                    System.out.println("✅ Data kualitas terbaru ditemukan untuk id_sumber " + idSumber);
                } else {
                    System.out.println("⚠️ Tidak ada data uji kualitas untuk sumber id " + idSumber);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Gagal mengambil data kualitas terbaru: " + e.getMessage());
            throw e;
        }

        return k;
    }
}
