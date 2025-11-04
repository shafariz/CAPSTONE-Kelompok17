package dao.interfaces;

public interface iLaporanDao {
    void insert(model.laporan1 l);
    java.util.List<model.laporan1> getAll();
}
