/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.daerah;
import service.databaseConnection;

public class adminDao {
    private final Connection conn = (Connection) databaseConnection.getConnection();

    public model.daerah getDaerahAdmin(int idPengguna) {
        String sql = """
            SELECT d.id_daerah, d.kotakabupaten, d.kecamatan
            FROM admin a
            JOIN daerah d ON a.id_daerah = d.id_daerah
            WHERE a.id_pengguna = ?
        """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPengguna);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                model.daerah daerah = new model.daerah();
                daerah.setIdDaerah(rs.getInt("id_daerah"));
                daerah.setKotaKabupaten(rs.getString("kotakabupaten"));
                daerah.setKecamatan(rs.getString("kecamatan"));
                return daerah;
            }
        } catch (SQLException e) {
            System.err.println("❌ Gagal mengambil data daerah admin: " + e.getMessage());
        }
        return null;
    }
}

