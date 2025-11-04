package dao;

import dao.interfaces.iDistribusiAirDao;
import model.distribusiAir;
import service.databaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class distribusiAirDao implements iDistribusiAirDao {
    private final Connection conn;

    public distribusiAirDao() {
        conn = databaseConnection.getConnection();
    }

    @Override
    public void insert(distribusiAir d) throws SQLException {
        String sql = "INSERT INTO distribusi_air (tanggal_distribusi, volume_distribusi, id_sumber, id_daerah) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, d.getTanggalDistribusi());
            stmt.setDouble(2, d.getVolumeDistribusi());
            stmt.setInt(3, d.getIdSumber());
            stmt.setInt(4, d.getIdDaerah());
            stmt.executeUpdate();
            System.out.println("✅ Data distribusi berhasil ditambahkan!");
        } catch (SQLException e) {
            System.err.println("❌ Gagal menambah data distribusi: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<distribusiAir> getAll() throws SQLException {
        List<distribusiAir> list = new ArrayList<>();
        String sql = "SELECT * FROM distribusi_air ORDER BY id_distribusi ASC";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                distribusiAir d = new distribusiAir();
                d.setIdDistribusi(rs.getInt("id_distribusi"));
                d.setIdSumber(rs.getInt("id_sumber"));
                d.setIdDaerah(rs.getInt("id_daerah"));
                d.setTanggalDistribusi(rs.getDate("tanggal_distribusi"));
                d.setVolumeDistribusi(rs.getDouble("volume_distribusi"));
                list.add(d);
            }

        } catch (SQLException e) {
            System.err.println("❌ Gagal memuat semua distribusi: " + e.getMessage());
            throw e;
        }
        return list;
    }

    @Override
    public List<distribusiAir> getByDaerah(int idDaerah) throws SQLException {
        List<distribusiAir> list = new ArrayList<>();
        String sql = """
            SELECT * FROM distribusi_air
            WHERE id_daerah = ?
            ORDER BY id_distribusi DESC
        """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idDaerah);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    distribusiAir d = new distribusiAir();
                    d.setIdDistribusi(rs.getInt("id_distribusi"));
                    d.setIdSumber(rs.getInt("id_sumber"));
                    d.setIdDaerah(rs.getInt("id_daerah"));
                    d.setTanggalDistribusi(rs.getDate("tanggal_distribusi"));
                    d.setVolumeDistribusi(rs.getDouble("volume_distribusi"));
                    list.add(d);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Gagal memuat distribusi berdasarkan ID daerah: " + e.getMessage());
            throw e;
        }
        return list;
    }
}
