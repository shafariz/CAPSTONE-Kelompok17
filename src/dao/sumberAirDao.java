package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.sumberAir;
import service.databaseConnection;

public class sumberAirDao implements dao.interfaces.iSumberAirDao {

    @Override
    public List<sumberAir> getAll() throws SQLException {
        List<sumberAir> list = new ArrayList<>();
        String sql = "SELECT * FROM sumber_air";
        try (Connection conn = databaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                sumberAir s = new sumberAir();
                s.setIdSumber(rs.getInt("id_sumber"));
                s.setNamaSumber(rs.getString("nama_sumber"));
                s.setJenisSumber(rs.getString("jenis_sumber"));
                s.setStatus(rs.getString("status"));
                s.setLokasi(rs.getString("lokasi"));
                list.add(s);
            }
        }
        return list;
    }

    @Override
    public void insert(sumberAir s) throws SQLException {
        String sql = "INSERT INTO sumber_air (nama_sumber, jenis_sumber, status, lokasi) VALUES (?, ?, ?, ?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getNamaSumber());
            ps.setString(2, s.getJenisSumber());
            ps.setString(3, s.getStatus());
            ps.setString(4, s.getLokasi());
            ps.executeUpdate();
        }
    }

    @Override
    public void update(sumberAir s) throws SQLException {
        String sql = "UPDATE sumber_air SET nama_sumber=?, jenis_sumber=?, status=?, lokasi=? WHERE id_sumber=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getNamaSumber());
            ps.setString(2, s.getJenisSumber());
            ps.setString(3, s.getStatus());
            ps.setString(4, s.getLokasi());
            ps.setInt(5, s.getIdSumber());
            ps.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM sumber_air WHERE id_sumber=?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public sumberAir getById(int id) throws SQLException {
        sumberAir s = null;
        String sql = "SELECT * FROM sumber_air WHERE id_sumber = ?";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    s = new sumberAir();
                    s.setIdSumber(rs.getInt("id_sumber"));
                    s.setNamaSumber(rs.getString("nama_sumber"));
                    s.setJenisSumber(rs.getString("jenis_sumber"));
                    s.setStatus(rs.getString("status"));
                    s.setLokasi(rs.getString("lokasi"));
                }
            }
        }
        return s;
    }

    @Override
    public boolean isNamaSumberExist(String namaSumber) throws SQLException {
        String sql = "SELECT COUNT(*) FROM sumber_air WHERE LOWER(nama_sumber) = LOWER(?)";
        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, namaSumber);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }
}
