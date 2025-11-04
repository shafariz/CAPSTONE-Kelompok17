package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.daerah;
import service.databaseConnection;

public class daerahDao {

    public List<daerah> getAll() {
        List<daerah> daftarDaerah = new ArrayList<>();

        String sql = "SELECT id_daerah, kotakabupaten, kecamatan FROM daerah";

        try (Connection conn = databaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                daerah d = new daerah();
                d.setIdDaerah(rs.getInt("id_daerah"));
                d.setKotaKabupaten(rs.getString("kotakabupaten"));
                d.setKecamatan(rs.getString("kecamatan"));
                daftarDaerah.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftarDaerah;
    }
    
    public daerah getById(int id) {
    daerah d = null;
    String sql = "SELECT id_daerah, kotakabupaten, kecamatan FROM daerah WHERE id_daerah = ?";

    try (Connection conn = databaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, id);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                d = new daerah();
                d.setIdDaerah(rs.getInt("id_daerah"));
                d.setKotaKabupaten(rs.getString("kotakabupaten"));
                d.setKecamatan(rs.getString("kecamatan"));
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return d;
}
    
    public daerah getByNama(String kotaKabupaten, String kecamatan) throws SQLException {
    daerah d = null;
    String sql = "SELECT * FROM daerah WHERE kotakabupaten = ? AND kecamatan = ?";

    try (Connection conn = databaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, kotaKabupaten);
        stmt.setString(2, kecamatan);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                d = new daerah();
                d.setIdDaerah(rs.getInt("id_daerah"));
                d.setKotaKabupaten(rs.getString("kotakabupaten"));
                d.setKecamatan(rs.getString("kecamatan"));
            }
        }
    }
    return d;
}

}
