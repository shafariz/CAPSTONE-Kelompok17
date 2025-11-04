package dao.interfaces;

import model.distribusiAir;
import java.util.List;
import java.sql.SQLException;

public interface iDistribusiAirDao {
    void insert(distribusiAir d) throws SQLException;
    List<distribusiAir> getAll() throws SQLException;
    List<distribusiAir> getByDaerah(int idDaerah) throws SQLException;
}
