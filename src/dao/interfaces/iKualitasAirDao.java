package dao.interfaces;

import model.kualitasAir;
import java.util.List;
import java.sql.SQLException;

public interface iKualitasAirDao {
    
    void insert(kualitasAir kualitas) throws SQLException;
    List<kualitasAir> getAll() throws SQLException;
    List<kualitasAir> getBySumber(int idSumber) throws SQLException;
    kualitasAir getTerbaruBySumberId(int idSumber) throws SQLException;
}
