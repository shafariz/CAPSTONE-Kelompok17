package dao.interfaces;

import model.Pengguna;
import java.util.List;
import java.sql.SQLException;

public interface iPenggunaDao {
    void insert(Pengguna pengguna) throws SQLException;
    Pengguna findByUsername(String username) throws SQLException;
    List<Pengguna> getAll() throws SQLException;
}
