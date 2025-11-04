package controller;

import dao.sumberAirDao;
import dao.kualitasAirDao;
import dao.laporanDao;
import dao.distribusiAirDao;

import java.sql.SQLException;
import java.util.List;

import model.sumberAir;
import model.kualitasAir;
import model.laporan1;
import model.distribusiAir;

public class adminController {

    private final sumberAirDao sumberDao;
    private final kualitasAirDao kualitasDao;
    private final laporanDao laporanDao;
    private final distribusiAirDao distribusiDao;

    public adminController() throws SQLException {
        this.sumberDao = new sumberAirDao();
        this.kualitasDao = new kualitasAirDao();
        this.laporanDao = new laporanDao();
        this.distribusiDao = new distribusiAirDao();
    }

    public void tambahSumber(sumberAir s) throws SQLException {
        sumberDao.insert(s);
    }

    public List<sumberAir> lihatSemuaSumber() throws SQLException {
        return sumberDao.getAll();
    }

    public void tambahKualitas(kualitasAir k) throws SQLException {
        kualitasDao.insert(k);
    }

    public List<kualitasAir> lihatSemuaKualitas() throws SQLException {
        return kualitasDao.getAll();
    }

    public void tambahDistribusi(distribusiAir d) throws SQLException {
        distribusiDao.insert(d);
    }

    public List<distribusiAir> lihatDistribusi() throws SQLException {
        return distribusiDao.getAll();
    }

    public List<laporan1> lihatSemuaLaporan() {
        return laporanDao.getAll();
    }

    private String tentukanStatus(double ph) {
        if (ph >= 6.5 && ph <= 8.5) {
            return "Layak";
        } else {
            return "Tidak Layak";
        }
    }
}
