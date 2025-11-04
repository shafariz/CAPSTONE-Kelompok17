package controller;

import dao.laporanDao;
import dao.distribusiAirDao;

import model.laporan1;
import model.distribusiAir;

import java.sql.SQLException;
import java.util.List;

public class wargaController {
    
    private final laporanDao laporanDao;
    private final distribusiAirDao distribusiDao;

    public wargaController() throws SQLException {
        this.laporanDao = new laporanDao();
        this.distribusiDao = new distribusiAirDao();
    }

    public void buatLaporan(laporan1 l) throws SQLException {
        laporanDao.insert(l);
    }

    public List<distribusiAir> lihatDistribusiDaerah(int idDaerah) throws SQLException {
        return distribusiDao.getByDaerah(idDaerah);
    }
}
