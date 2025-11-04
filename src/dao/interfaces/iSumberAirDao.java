package dao.interfaces;

import model.sumberAir;
import java.util.List;
import java.sql.SQLException;

public interface iSumberAirDao {
    void insert(sumberAir sumber) throws SQLException;
    List<sumberAir> getAll() throws SQLException;
    void update(sumberAir sumber) throws SQLException;
    void delete(int idSumber) throws SQLException;
    sumberAir getById(int id) throws SQLException;
    boolean isNamaSumberExist(String namaSumber) throws SQLException;
}
