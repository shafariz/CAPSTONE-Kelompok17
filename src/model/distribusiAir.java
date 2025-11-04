package model;

import java.sql.Date;

public class distribusiAir {
    private int idDistribusi;
    private Date tanggalDistribusi;
    private double volumeDistribusi;
    private int idSumber;
    private int idDaerah;

    public int getIdDistribusi() { return idDistribusi; }
    public void setIdDistribusi(int idDistribusi) { this.idDistribusi = idDistribusi; }

    public Date getTanggalDistribusi() { return tanggalDistribusi; }
    public void setTanggalDistribusi(Date tanggalDistribusi) { this.tanggalDistribusi = tanggalDistribusi; }

    public double getVolumeDistribusi() { return volumeDistribusi; }
    public void setVolumeDistribusi(double volumeDistribusi) { this.volumeDistribusi = volumeDistribusi; }

    public int getIdSumber() { return idSumber; }
    public void setIdSumber(int idSumber) { this.idSumber = idSumber; }

    public int getIdDaerah() { return idDaerah; }
    public void setIdDaerah(int idDaerah) { this.idDaerah = idDaerah; }
}
